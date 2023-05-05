package com.example.sss.lms.service;

import com.example.sss.lms.dto.CoursesDto;
import com.example.sss.lms.exception.UserNotFoundException;

import java.util.List;

public interface CourseService {

    Integer createNewBooking(CoursesDto dto);

    Integer createNewCourse(CoursesDto dto);

    List<CoursesDto> all();

    Integer deleteCourse(Long courseId) throws UserNotFoundException;

    Integer updateCourse(CoursesDto dto);

    CoursesDto fetchCourseDetails(Long id) throws UserNotFoundException;
}