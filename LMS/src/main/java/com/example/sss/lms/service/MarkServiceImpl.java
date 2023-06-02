package com.example.sss.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sss.lms.domain.Mark;
import com.example.sss.lms.dto.MarkDto;
import com.example.sss.lms.exception.MarkNotFoundException;
import com.example.sss.lms.repository.MarkRepository;
import com.example.sss.lms.util.MarkMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class MarkServiceImpl implements MarkService {
    
    public final MarkRepository repository;
    public final MarkMapper mapper;


    @Override
    public Integer createNewMark(MarkDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<MarkDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }


    @Override
    public Integer deleteMark(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public MarkDto fetchMarkDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<Mark> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new MarkNotFoundException("Mark" + id + "Not Found")));
    }


    @Override
    public Integer updateMark(MarkDto dto) {
        // TODO Auto-generated method stub
        Long id= dto.getId();
        Mark mark= repository.findById(id).orElseThrow(() -> new MarkNotFoundException("Mark not found"));
        mark.setName(dto.getName());
        mark.setMarks(dto.getMarks());
        mark.setGrade(dto.getGrade());
        mark.setFeedback(dto.getFeedback());
       
        repository.save(mark);

    
        return 1;
    }

}