package com.example.sss.lms.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sss.lms.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUserNameAndPassword(String userName, String password);

    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);
}