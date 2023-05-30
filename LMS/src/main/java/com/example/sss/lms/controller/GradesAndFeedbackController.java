package com.example.sss.lms.controller;

import com.example.sss.lms.domain.GradesAndFeedback;
import com.example.sss.lms.dto.AppResponse;
import com.example.sss.lms.dto.GardesAndFeedbackDto;
import com.example.sss.lms.service.GradesAndFeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/gradesAndFeedback")
@RestController

public class GradesAndFeedbackController {
    private final GradesAndFeedbackService gradesAndFeedbackService;

    @PostMapping(value = "/{userId}/feedback", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createGradedsAndFeedback(@Valid @PathVariable Long userId, @RequestBody GardesAndFeedbackDto dto) {
        Integer sts = gradesAndFeedbackService.createGradedsAndFeedback(userId,dto);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("feedback submitted.")
                .bd(sts)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    //will be used when user clicks show feedbacks

    @GetMapping(value = "/feedback", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<GardesAndFeedbackDto>>> getAllFeedbacks() {
        List<GardesAndFeedbackDto> sts = gradesAndFeedbackService.listAllGradesAndFeedbacks();
        AppResponse<List<GardesAndFeedbackDto>> response = AppResponse.<List<GardesAndFeedbackDto>>builder()
                .sts("success")
                .msg("All Feedbacks")
                .bd(sts)
                .build();
        return ResponseEntity.ok().body(response);
    }
}
