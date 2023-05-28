package com.example.sss.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sss.lms.domain.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}