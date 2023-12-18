package com.myquizzapp.quizzpp.service;

import com.myquizzapp.quizzpp.dao.QuestionDao;
import com.myquizzapp.quizzpp.entitys.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(Integer id) {
        return questionDao.findById(id);
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionDao.save(question);
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionDao.deleteById(id);
    }

    @Override
    public Question updateQuestion(Question question, Integer id) {
        Optional<Question> optionalQuestion = questionDao.findById(id);

        if (optionalQuestion.isPresent()) {
            Question existingQuestion = optionalQuestion.get();
            // Update the question properties with the provided question (similar to your previous update logic)
            // ...
            return questionDao.save(existingQuestion);
        } else {
            throw new IllegalArgumentException("Question not found with id: " + id);
        }
    }



}
