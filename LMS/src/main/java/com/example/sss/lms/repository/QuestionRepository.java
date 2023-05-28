package com.example.sss.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sss.lms.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}