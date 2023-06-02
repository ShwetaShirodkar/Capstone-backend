package com.example.sss.lms.util;

import org.springframework.stereotype.Component;

import com.example.sss.lms.domain.StudyPlan;
import com.example.sss.lms.dto.StudyPlanDto;

@Component
public class StudyPlanMapper {
    
    public StudyPlan toDomain(StudyPlanDto dto){
        
        return StudyPlan.builder().startDate(dto.getStartDate()).targetDate(dto.getTargetDate()).plan(dto.getPlan()).progress(dto.getProgress()).build();

    }

    public StudyPlanDto toDto(StudyPlan domain){
        return new StudyPlanDto(domain.getId(), domain.getStartDate(), domain.getTargetDate(), domain.getPlan(), domain.getProgress());
    }
}
