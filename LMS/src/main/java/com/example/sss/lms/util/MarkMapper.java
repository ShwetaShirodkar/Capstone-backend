package com.example.sss.lms.util;

import org.springframework.stereotype.Component;

import com.example.sss.lms.domain.Mark;
import com.example.sss.lms.dto.MarkDto;

@Component
public class MarkMapper {
    
    public Mark toDomain(MarkDto dto){
        return Mark.builder().name(dto.getName()).marks(dto.getMarks()).grade(dto.getGrade()).feedback(dto.getFeedback()).build();

    }

    public MarkDto toDto(Mark domain){
        return new MarkDto(domain.getId(), domain.getName(), domain.getMarks(), domain.getGrade(), domain.getFeedback() );
    }
}