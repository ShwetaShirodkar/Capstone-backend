package com.example.sss.lms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sss.lms.domain.Courses;
import com.example.sss.lms.domain.User;
import com.example.sss.lms.dto.CreateUserDto;
import com.example.sss.lms.dto.LoginDto;
import com.example.sss.lms.dto.LoginResponseDto;
import com.example.sss.lms.dto.StudentEnrolledDto;
import com.example.sss.lms.dto.UserCoursesDto;
import com.example.sss.lms.dto.UserDto;
import com.example.sss.lms.exception.CourseNotFoundException;
import com.example.sss.lms.exception.UserNotFoundException;
import com.example.sss.lms.repository.CoursesRepository;
import com.example.sss.lms.repository.UserRepository;
import com.example.sss.lms.util.DynamicMapper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final DynamicMapper dynamicMapper;
    private final CoursesRepository courseRepo;


    @Override
    public Integer signup(CreateUserDto dto) {
        User user = new User();
        user.setCreated(LocalDate.now());
        BeanUtils.copyProperties(dto, user);
        repository.save(user);
        return 1;
    }

    @Override
    public UserDto login(LoginDto dto) throws UserNotFoundException {
        Optional<User> op = repository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword());
        User user = op.orElseThrow(() -> new UserNotFoundException("User Not Found"));

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }

  
    //    public Integer enrollCourse(Long userId, Long coursesId) {
    //        User user = repository.findById(userId)
    //                .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));
    //
    //        if (user.getRole().equals("admin"))
    //            throw new InvalidRoleException("Admin can't enroll course");
    //        Courses bookings = courseRepo.findById(coursesId)
    //                .orElseThrow(() -> new CourseNotFoundException("Course not Found for " + coursesId + " id"));
    //
    //        if (user.getCourses().contains(bookings))
    //            throw new DuplicateEventException("Course already enrolled...");
    //        user.getCourses().add(bookings);
    //        repository.save(user);
    //        return 1;
    //
    //    }
        @Override
        public Integer enrollCourse(Long userId, Long courseID) {
    
            User user = repository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));
    
            // if (user.getRole().equals("admin"))
            // throw new InvalidRoleException("Admin can't book Event");
            Courses courses = courseRepo.findById(courseID)
                    .orElseThrow(() -> new CourseNotFoundException("Course not Found for " + courseID + " id"));
    
            if (courses.getUsers().contains(user))
                throw new UserNotFoundException("already enrolled");
            courses.getUsers().add(user);
            courseRepo.save(courses);
            return 1;
        }
    
    
        @Override
        public List<UserCoursesDto> getAllEnrollments(Long userId) {
            User user = repository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));
    
            List<UserCoursesDto> collect = user.getCourses()
                    .stream()
                    .map(enrollement -> dynamicMapper.convertor(enrollement, new UserCoursesDto()))
                    .collect(Collectors.toList());
            if (collect.isEmpty())
                throw new CourseNotFoundException("No enrollments found ");
    
            return collect;
        }
    
        @Override
        public List<StudentEnrolledDto> getAllStudentEnrolled() {
            List<StudentEnrolledDto> studentEnrolledDtos = new ArrayList<>();
            List<User> users = repository.findAll();
            for (User user : users) {
                for (Courses courses : user.getCourses()) {
                    StudentEnrolledDto studentEnrolledDto = new StudentEnrolledDto();
    
                    studentEnrolledDto.setUserName(user.getUserName());
                    studentEnrolledDto.setFacultyName(courses.getFacultyName());
                    studentEnrolledDto.setCourseName(courses.getCourseName());
    
                    studentEnrolledDtos.add(studentEnrolledDto);
                }
            }
            return studentEnrolledDtos;
        }
    
        //    @Override
    //    public List<UserCoursesDto> getCurrentEnrollments(Long userId) {
    //        User user = repository.findById(userId)
    //                .orElseThrow(() -> new UserNotFoundException("No User found for " + userId + " ID"));
    //
    //        if (user.getRole().equals("admin"))
    //            throw new InvalidRoleException("No bookings for Admin");
    //
    //        LocalDate currentDate = LocalDate.now();
    //
    //        List<UserCoursesDto> collect = user.getCourses().stream()
    //                .filter(enrollment -> enrollment.getEndDate().isAfter(currentDate))
    //                .map(enrollment -> dynamicMapper.convertor(enrollment, new UserCoursesDto()))
    //                .collect(Collectors.toList());
    //
    //        if (collect.isEmpty())
    //            throw new CourseNotFoundException("No courses found enroll one.");
    //
    //        return collect;
    //    }
        @Override
        public LoginResponseDto loginUserForResponse(LoginDto dto) {
            Optional<User> op = repository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    
            User user = op.orElseThrow(() -> new UserNotFoundException("Email/Password is not valid"));
            return dynamicMapper.convertor(user, new LoginResponseDto());
        }
    
        @Override
        public List<UserDto> getAllUser() {
            List<UserDto> listusers = repository.findAll()
                    .stream()
                    .map(user -> dynamicMapper.convertor(user, new UserDto()))
                    .collect(Collectors.toList());
            if (listusers.isEmpty()) {
                throw new UserNotFoundException("no Users present");
            }
            return listusers;
        }
    
    
}
