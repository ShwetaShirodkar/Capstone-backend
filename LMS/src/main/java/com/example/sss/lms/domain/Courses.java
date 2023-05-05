package com.example.sss.lms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String facultyName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String material;
    
    private String recording;



}