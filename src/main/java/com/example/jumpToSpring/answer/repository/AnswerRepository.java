package com.example.jumpToSpring.answer.repository;

import com.example.jumpToSpring.answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
