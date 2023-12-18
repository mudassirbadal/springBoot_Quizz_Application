package com.myquizzapp.quizzpp.dao;

import com.myquizzapp.quizzpp.entitys.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

     List<Question> findByCategory(String category);

//     @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER By RANDOM() LIMIT :numQuestion",nativeQuery = true)
     @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQuestion", nativeQuery = true)
     List<Question> findRandomQuestionByCategory(String category, int numQuestion);


}
