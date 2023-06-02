package com.example.sss.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.sss.lms.domain.Mark;

public interface MarkRepository extends JpaRepository<Mark,Long> {
    
}
