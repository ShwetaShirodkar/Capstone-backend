package com.example.sss.lms.repository;



import com.example.sss.lms.domain.Courses;
import com.example.sss.lms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
    List<Courses> findAllByCourseName(String courseName);



}
