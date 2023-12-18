package com.myquizzapp.quizzpp.controller;

import com.myquizzapp.quizzpp.entitys.Question;
import com.myquizzapp.quizzpp.entitys.QuestionWrapper;
import com.myquizzapp.quizzpp.entitys.Response;
import com.myquizzapp.quizzpp.service.QuizService;
import com.myquizzapp.quizzpp.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQuestion, @RequestParam String title) {
       return quizService.createQuiz(category,numQuestion,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
       return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calResult(id,responses);
    }
}