package com.myquizzapp.quizzpp.controller;

import com.myquizzapp.quizzpp.entitys.Question;
import com.myquizzapp.quizzpp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/hello")
    public String hello(){
        return "Just for checking purpose";
    }


    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    /*Get the Questions BY category*/
    @GetMapping("/categories/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category),HttpStatus.OK);
    }

    /*Get the Questions By id*/
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Question> > getQuestionById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.questionService.getQuestionById(id),HttpStatus.OK);
    }

    /*PostMapping*/
    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(this.questionService.addQuestion(question),HttpStatus.CREATED);
    }

    /*Put-Mapping*/
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
        return this.questionService.updateQuestion(question, id);
    }

    /*Delete*/
    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        this.questionService.deleteQuestion(id);
        return "Deleted Successfully";
    }

}
