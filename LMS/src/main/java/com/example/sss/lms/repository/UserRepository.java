package com.example.sss.lms.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sss.lms.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> getByEmailIdAndPassword(String emailId, String password);
}