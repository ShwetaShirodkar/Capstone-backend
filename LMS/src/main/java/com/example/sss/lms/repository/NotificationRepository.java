package com.example.sss.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sss.lms.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long>{
    
}