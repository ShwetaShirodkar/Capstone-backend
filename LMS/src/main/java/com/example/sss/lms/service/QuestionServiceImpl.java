package com.example.sss.lms.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sss.lms.domain.Answer;
import com.example.sss.lms.domain.Question;
import com.example.sss.lms.dto.AnswerDto;
import com.example.sss.lms.dto.QuestionDto;
import com.example.sss.lms.exception.QuestionNotFoundException;
import com.example.sss.lms.repository.AnswerRepository;
import com.example.sss.lms.repository.QuestionRepository;
import com.example.sss.lms.util.QuestionMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final AnswerRepository answerRepository;
    
   

    @Override
    public QuestionDto createQuestion(QuestionDto questionDTO) {
        Question question = questionMapper.toQuestionEntity(questionDTO);
        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toQuestionDTO(savedQuestion);
    }

    @Override
    public QuestionDto getQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + id));
        return questionMapper.toQuestionDTO(question);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(questionMapper::toQuestionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto createAnswer(Long questionId, AnswerDto answerDTO) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));

        // if (question.getAnswer() != null) {
        //     throw new BadRequestException("Answer already exists for question with id: " + questionId);
        // }

        Answer answer = questionMapper.toAnswerEntity(answerDTO);
        question.setAnswer(answer);
        Question savedQuestion = questionRepository.save(question);

        return questionMapper.toAnswerDTO(savedQuestion.getAnswer());
    }

    @Override
    public AnswerDto updateAnswer(Long questionId, AnswerDto answerDTO) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));

        Answer answer = question.getAnswer();
        if (answer == null) {
            throw new QuestionNotFoundException("Answer not found for question with id: " + questionId);
        }

        answer.setAnswer(answerDTO.getAnswer());
        Answer updatedAnswer = answerRepository.save(answer);

        return questionMapper.toAnswerDTO(updatedAnswer);
    }

    @Override
    public void deleteAnswer(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));

        Answer answer = question.getAnswer();
        if (answer == null) {
            throw new QuestionNotFoundException("Answer not found for question with id: " + questionId);
        }

        question.setAnswer(null);
        questionRepository.save(question);
    }
    
    @Override
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + id));
        questionRepository.delete(question);
    }
}

