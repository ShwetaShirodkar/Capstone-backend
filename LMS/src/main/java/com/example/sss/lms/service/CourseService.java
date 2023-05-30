package com.example.sss.lms.service;

import com.example.sss.lms.dto.CoursesDto;
import com.example.sss.lms.exception.CourseNotFoundException;
import com.example.sss.lms.exception.UserNotFoundException;

import java.util.List;

public interface CourseService {



    Integer createNewCourse(CoursesDto dto);

    List<CoursesDto> all();

    Integer deleteCourse(Long courseId) throws UserNotFoundException;

    Integer updateCourse(CoursesDto dto,Long courseId);

    CoursesDto fetchCourseDetails(Long id) throws UserNotFoundException;
    List<CoursesDto> getCoursesByCourseName(String courseName) throws CourseNotFoundException;


}
