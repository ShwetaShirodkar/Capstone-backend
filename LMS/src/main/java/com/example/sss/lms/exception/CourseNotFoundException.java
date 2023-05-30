package com.example.sss.lms.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String msg)
    {
        super("course not found");
    }
}
