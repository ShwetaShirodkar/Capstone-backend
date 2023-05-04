package com.example.sss.lms.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sss.lms.domain.User;
import com.example.sss.lms.dto.Userdto;
import com.example.sss.lms.exception.UserNotFoundException;
import com.example.sss.lms.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository repository;

    @Override
    public Integer signup(Userdto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        repository.save(user);
        return 1;
    }

    @Override
    public Userdto login(String emailId, String password) throws UserNotFoundException {
        Optional<User> op = repository.getByEmailIdAndPassword(emailId, password);
        User user = op.orElseThrow(() -> new UserNotFoundException("User Not Found"));

        Userdto userDto = new Userdto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }
}