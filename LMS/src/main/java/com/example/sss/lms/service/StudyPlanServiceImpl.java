package com.example.sss.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sss.lms.domain.StudyPlan;
import com.example.sss.lms.dto.StudyPlanDto;
import com.example.sss.lms.exception.PlanNotFoundException;
import com.example.sss.lms.repository.StudyPlanRepository;
import com.example.sss.lms.util.StudyPlanMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class StudyPlanServiceImpl implements StudyPlanService{
    
    public final StudyPlanRepository repository;
    public final StudyPlanMapper mapper;


    @Override
    public Integer createNewPlan(StudyPlanDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<StudyPlanDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }


    @Override
    public Integer deletePlan(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public StudyPlanDto fetchPlanDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<StudyPlan> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new PlanNotFoundException("Plan" + id + "Not Found")));
    }


    @Override
    public Integer updatePlan(StudyPlanDto dto) {
        // TODO Auto-generated method stub
        Long id= dto.getId();
        StudyPlan plan= repository.findById(id).orElseThrow(() -> new PlanNotFoundException("Course not found"));
        plan.setStartDate(dto.getStartDate());
        plan.setTargetDate(dto.getTargetDate());
        plan.setPlan(dto.getPlan());
        plan.setProgress(dto.getProgress());
        repository.save(plan);

    
        return 1;
    }
}
