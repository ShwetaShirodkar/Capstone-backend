package com.example.sss.lms.service;

import java.util.List;

import com.example.sss.lms.dto.ScheduleDto;
import com.example.sss.lms.exception.ScheduleNotFoundException;


public interface ScheduleService {
    
    Integer createNewSchedule(ScheduleDto course);
    List<ScheduleDto> all();
    Integer deleteSchedule(Long id) throws ScheduleNotFoundException;
    ScheduleDto fetchScheduleDetails(Long id) throws ScheduleNotFoundException;
    Integer updateSchedule(ScheduleDto course);
    
}