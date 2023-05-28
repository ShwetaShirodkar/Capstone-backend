package com.example.sss.lms.exception;

public class QuestionNotFoundException extends RuntimeException{
    
    public QuestionNotFoundException(String msg){
        super(msg);
    }
}