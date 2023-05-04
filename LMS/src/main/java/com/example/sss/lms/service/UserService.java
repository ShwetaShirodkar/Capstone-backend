package com.example.sss.lms.service;
import com.example.sss.lms.dto.Userdto;
import com.example.sss.lms.exception.UserNotFoundException;


public interface UserService {
    Integer signup(Userdto dto);

     Userdto login(String emailId, String password) throws UserNotFoundException;
}