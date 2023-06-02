package com.example.sss.lms.util;

import org.springframework.stereotype.Component;

import com.example.sss.lms.domain.Schedule;
import com.example.sss.lms.dto.ScheduleDto;

@Component
public class ScheduleMapper {
    
    public Schedule toDomain(ScheduleDto dto){
        return Schedule.builder().courseName(dto.getCourseName()).date(dto.getDate()).time(dto.getTime()).link(dto.getLink()).recording(dto.getRecording()).build();

    }

    public ScheduleDto toDto(Schedule domain){
        return new ScheduleDto(domain.getId(), domain.getCourseName(), domain.getDate(),domain.getTime(), domain.getLink(), domain.getRecording());
    }
}