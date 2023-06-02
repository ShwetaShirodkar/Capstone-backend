package com.example.sss.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sss.lms.domain.Schedule;
import com.example.sss.lms.dto.ScheduleDto;
import com.example.sss.lms.exception.ScheduleNotFoundException;
import com.example.sss.lms.repository.ScheduleRepository;
import com.example.sss.lms.util.ScheduleMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService{
    
    public final ScheduleRepository repository;
    public final ScheduleMapper mapper;


    @Override
    public Integer createNewSchedule(ScheduleDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<ScheduleDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }


    @Override
    public Integer deleteSchedule(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public ScheduleDto fetchScheduleDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<Schedule> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new ScheduleNotFoundException("Schedule" + id + "Not Found")));
    }


    @Override
    public Integer updateSchedule(ScheduleDto dto) {
        // TODO Auto-generated method stub
        Long id= dto.getId();
        Schedule schedule= repository.findById(id).orElseThrow(() -> new ScheduleNotFoundException("Class schedule not found"));
        schedule.setCourseName(dto.getCourseName());
        schedule.setDate(dto.getDate());
        schedule.setTime(dto.getTime());
        schedule.setLink(dto.getLink());
        schedule.setRecording(dto.getRecording());
        repository.save(schedule);
        return 1;
    }

}
