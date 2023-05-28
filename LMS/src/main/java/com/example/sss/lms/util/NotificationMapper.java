package com.example.sss.lms.util;

import org.springframework.stereotype.Component;

import com.example.sss.lms.domain.Notification;
import com.example.sss.lms.dto.NotificationDto;

@Component
public class NotificationMapper {
    
    public Notification toDomain(NotificationDto dto){
        return Notification.builder().date(dto.getDate()).notification(dto.getNotification()).build();

    }

    public NotificationDto toDto(Notification domain){
        return new NotificationDto(domain.getId(), domain.getDate(), domain.getNotification());
    }
}
