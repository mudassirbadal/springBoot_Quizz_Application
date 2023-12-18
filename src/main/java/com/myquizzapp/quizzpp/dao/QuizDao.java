package com.myquizzapp.quizzpp.dao;

import com.myquizzapp.quizzpp.entitys.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {


}
