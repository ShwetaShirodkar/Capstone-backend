package com.example.sss.lms.service;

import com.example.sss.lms.dto.NotificationDto;
import com.example.sss.lms.exception.NotificationNotFoundException;

import java.util.List;

public interface NotificationService {

    Integer createNewNotification(NotificationDto notification);
    List<NotificationDto> all();
    Integer deleteNotification(Long id) throws NotificationNotFoundException;
    NotificationDto fetchNotificationDetails(Long id) throws NotificationNotFoundException;
    Integer updateNotification(NotificationDto notification);

}
