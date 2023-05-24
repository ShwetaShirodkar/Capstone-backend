package com.example.sss.lms.service;
import com.example.sss.lms.dto.UserDto;
import com.example.sss.lms.exception.UserNotFoundException;

import java.util.List;

import com.example.sss.lms.dto.CreateUserDto;
import com.example.sss.lms.dto.LoginDto;
import com.example.sss.lms.dto.LoginResponseDto;
import com.example.sss.lms.dto.StudentEnrolledDto;
import com.example.sss.lms.dto.UserCoursesDto;

public interface UserService {
    
    Integer signup(CreateUserDto dto);

    UserDto login(LoginDto dto) throws UserNotFoundException;
    
    LoginResponseDto loginUserForResponse(LoginDto dto);

    List<UserDto> getAllUser ();


    Integer enrollCourse(Long userId,Long bookingsId);

    List<UserCoursesDto> getAllEnrollments(Long userId);

    List<StudentEnrolledDto> getAllStudentEnrolled();

//    List<UserCoursesDto> getCurrentEnrollments(Long userId);


}