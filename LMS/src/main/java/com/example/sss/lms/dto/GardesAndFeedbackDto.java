package com.example.sss.lms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class GardesAndFeedbackDto {
    private Long id;
    @NotEmpty(message = "feedback cant be empty")
    @NotNull(message = "feedback cant be null")
    @NotBlank(message = "feedback cant be blank")
    private String feedback;

    @NotEmpty(message = "Grade cant be empty")
    @NotNull(message = "Grade cant be null")
    @NotBlank(message = "Grade cant be blank")
    private Double grade;

    private String courseName;
}
