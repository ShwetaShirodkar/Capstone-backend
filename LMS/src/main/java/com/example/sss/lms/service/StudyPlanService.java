package com.example.sss.lms.service;

import java.util.List;

import com.example.sss.lms.dto.StudyPlanDto;
import com.example.sss.lms.exception.PlanNotFoundException;

public interface StudyPlanService {

    Integer createNewPlan(StudyPlanDto plan);
    List<StudyPlanDto> all();
    Integer deletePlan(Long id) throws PlanNotFoundException;
    StudyPlanDto fetchPlanDetails(Long id) throws PlanNotFoundException;
    Integer updatePlan(StudyPlanDto plan);
}
