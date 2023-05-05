package com.example.sss.lms.service;
import com.example.sss.lms.dto.UserDto;
import com.example.sss.lms.exception.UserNotFoundException;
import com.example.sss.lms.dto.CreateUserDto;
import com.example.sss.lms.dto.LoginDto;

public interface UserService {
    
    Integer signup(CreateUserDto dto);

    UserDto login(LoginDto dto) throws UserNotFoundException;
}