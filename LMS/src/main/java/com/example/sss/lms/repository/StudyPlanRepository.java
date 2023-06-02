package com.example.sss.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sss.lms.domain.StudyPlan;

public interface StudyPlanRepository extends JpaRepository<StudyPlan,Long>{
    
}
