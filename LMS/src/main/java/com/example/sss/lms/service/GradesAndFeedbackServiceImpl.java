package com.example.sss.lms.service;

import com.example.sss.lms.domain.GradesAndFeedback;
import com.example.sss.lms.domain.User;
import com.example.sss.lms.dto.GardesAndFeedbackDto;
import com.example.sss.lms.exception.GradesAndFeedbackNotFoundException;
import com.example.sss.lms.exception.UserNotFoundException;
import com.example.sss.lms.repository.GradesAndFeedbackRepository;
import com.example.sss.lms.repository.UserRepository;
import com.example.sss.lms.util.DynamicMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@AllArgsConstructor
@Service

public class GradesAndFeedbackServiceImpl implements GradesAndFeedbackService {
    private final GradesAndFeedbackRepository gradesAndFeedbackRepository;
    private final UserRepository usersRepository;

    private final DynamicMapper dynamicMapper;
    @Override
    public Integer createGradedsAndFeedback(Long id, GardesAndFeedbackDto dto) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not Found for " + id + " id"));

        GradesAndFeedback feedback = dynamicMapper.convertor(dto, new GradesAndFeedback());
        feedback.setUsers(user);
        gradesAndFeedbackRepository.save(feedback);
        return 1;
    }

    @Override
    public List<GardesAndFeedbackDto> listAllGradesAndFeedbacks() {
        List<GradesAndFeedback> feedbackList = gradesAndFeedbackRepository.findAll();
        List<GardesAndFeedbackDto> feedbackDtoList = new ArrayList<>();

        for (GradesAndFeedback gardesAndFeedback : feedbackList) {
            GardesAndFeedbackDto gardesAndFeedbackDto = new GardesAndFeedbackDto();
            BeanUtils.copyProperties(gardesAndFeedback, gardesAndFeedbackDto);
            feedbackDtoList.add(gardesAndFeedbackDto);
            if (feedbackDtoList.isEmpty()) {
                throw new GradesAndFeedbackNotFoundException("no feedback present ");
            }
        }

        return feedbackDtoList;
    }
}
