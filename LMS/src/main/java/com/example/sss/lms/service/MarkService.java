package com.example.sss.lms.service;

import java.util.List;

import com.example.sss.lms.dto.MarkDto;
import com.example.sss.lms.exception.MarkNotFoundException;

public interface MarkService {
    
    Integer createNewMark(MarkDto mark);
    List<MarkDto> all();
    Integer deleteMark(Long id) throws MarkNotFoundException;
    MarkDto fetchMarkDetails(Long id) throws MarkNotFoundException;
    Integer updateMark(MarkDto mark);
}
