package com.example.sss.lms.repository;

import com.example.sss.lms.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
}