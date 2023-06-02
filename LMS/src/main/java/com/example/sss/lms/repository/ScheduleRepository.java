package com.example.sss.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sss.lms.domain.Schedule;


public interface ScheduleRepository extends JpaRepository<Schedule,Long>{
    
}