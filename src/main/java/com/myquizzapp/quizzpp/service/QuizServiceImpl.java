package com.myquizzapp.quizzpp.service;

import com.myquizzapp.quizzpp.dao.QuestionDao;
import com.myquizzapp.quizzpp.dao.QuizDao;
import com.myquizzapp.quizzpp.entitys.Question;
import com.myquizzapp.quizzpp.entitys.QuestionWrapper;
import com.myquizzapp.quizzpp.entitys.Quiz;
import com.myquizzapp.quizzpp.entitys.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{

   @Autowired
   QuizDao quizDao;
   @Autowired
   QuestionDao questionDao;

    @Override
    public ResponseEntity<String> createQuiz(String category, int numQuestion, String title) {
        List<Question> questionsList = questionDao.findRandomQuestionByCategory(category,numQuestion);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionsList);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {

        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionListFormDb = quiz.get().getQuestions();

        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q : questionListFormDb) {
            QuestionWrapper questionWrapper = new QuestionWrapper(
                    q.getId(),
                    q.getQuestion_title(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            );
            questionForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> calResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questionList = quiz.getQuestions();

        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if(response.getResponse().equals(questionList.get(i).getRight_answer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }


}
