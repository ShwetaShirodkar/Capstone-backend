package com.example.sss.lms.exception;

public class DuplicateUserNameFoundException extends RuntimeException {
    public DuplicateUserNameFoundException(String msg) {
        super(msg);
    }
}
