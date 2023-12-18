package com.myquizzapp.quizzpp.service;

import com.myquizzapp.quizzpp.entitys.Question;

import java.util.List;
import java.util.Optional;


public interface QuestionService {


    public List<Question> getAllQuestions();


    Optional<Question> getQuestionById(Integer id);

    List<Question> getQuestionsByCategory(String category);

    Question addQuestion(Question question);

    void deleteQuestion(Integer id);

    Question updateQuestion(Question question, Integer id);
}
