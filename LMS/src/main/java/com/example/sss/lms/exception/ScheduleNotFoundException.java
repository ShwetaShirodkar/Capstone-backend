package com.example.sss.lms.exception;

public class ScheduleNotFoundException extends RuntimeException{
    
    public ScheduleNotFoundException(String msg){
        super(msg);
    }
}