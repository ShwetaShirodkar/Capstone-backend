package com.example.sss.lms.service;

import com.example.sss.lms.dto.GardesAndFeedbackDto;

import java.util.List;

public interface GradesAndFeedbackService {

    Integer createGradedsAndFeedback(Long id, GardesAndFeedbackDto dto);

    List<GardesAndFeedbackDto> listAllGradesAndFeedbacks();
}
