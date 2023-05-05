package com.example.sss.lms.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String msg)
    {
        super("booking not found");
    }
}