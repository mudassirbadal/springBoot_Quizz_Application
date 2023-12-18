package com.myquizzapp.quizzpp.service;

import com.myquizzapp.quizzpp.entitys.Question;
import com.myquizzapp.quizzpp.entitys.QuestionWrapper;
import com.myquizzapp.quizzpp.entitys.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {

    ResponseEntity<String> createQuiz(String category, int numQuestion, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id);

    ResponseEntity<Integer> calResult(Integer id, List<Response> responses);
}
