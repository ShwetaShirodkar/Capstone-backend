package com.example.sss.lms.dto;
import java.time.LocalDate;

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
@Getter
@Setter
@ToString
public class CoursesDto {

    @NotEmpty(message = "Username cant be empty")
    @NotNull(message = "Username cant be null")
    @NotBlank(message = "Username cant be blank")
    private String courseName;

    private long courseID;

    @NotEmpty(message = "Username cant be empty")
    @NotNull(message = "Username cant be null")
    @NotBlank(message = "Username cant be blank")
    private String facultyName;


    private LocalDate startDate;



    private LocalDate endDate;
    @NotBlank(message = "Material link cannot be blank")
    private String material;
    @NotBlank(message = "Material link cannot be blank")
    private String recordings;


    public CoursesDto(long courseId, String courseName, String facultyName, LocalDate startDate, LocalDate endDate, String material, String recording) {
    }
}