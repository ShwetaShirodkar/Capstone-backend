package com.example.sss.lms.util;

import org.springframework.stereotype.Component;

import com.example.sss.lms.domain.Answer;
import com.example.sss.lms.domain.Question;
import com.example.sss.lms.dto.AnswerDto;
import com.example.sss.lms.dto.QuestionDto;

@Component
public class QuestionMapper {
    public QuestionDto toQuestionDTO(Question question) {
        QuestionDto questionDTO = new QuestionDto();
        questionDTO.setId(question.getId());
        questionDTO.setStudentName(question.getStudentName());
        questionDTO.setQuestion(question.getQuestion());

        if (question.getAnswer() != null) {
            AnswerDto answerDTO = new AnswerDto();
            //answerDTO.setId(question.getAnswer().getId());
            answerDTO.setAnswer(question.getAnswer().getAnswer());
            questionDTO.setAnswer(answerDTO);
        }

        return questionDTO;
    }

    public Question toQuestionEntity(QuestionDto questionDTO) {
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setStudentName(questionDTO.getStudentName());
        question.setQuestion(questionDTO.getQuestion());

        if (questionDTO.getAnswer() != null) {
            Answer answer = new Answer();
            //answer.setId(questionDTO.getAnswer().getId());
            answer.setAnswer(questionDTO.getAnswer().getAnswer());
            question.setAnswer(answer);
        }

        return question;
    }

    public AnswerDto toAnswerDTO(Answer answer) {
        AnswerDto answerDTO = new AnswerDto();
        //answerDTO.setId(answer.getId());
        answerDTO.setAnswer(answer.getAnswer());
        return answerDTO;
    }

    public Answer toAnswerEntity(AnswerDto answerDTO) {
        Answer answer = new Answer();
        //answer.setId(answerDTO.getId());
        answer.setAnswer(answerDTO.getAnswer());
        return answer;
    }
}


// @Component
// public class QuestionMapper {
//     public QuestionDto toQuestionDTO(Question question) {
//         QuestionDto questionDTO = new QuestionDto();
//         questionDTO.setId(question.getId());
//         questionDTO.setStudentName(question.getStudentName());
//         questionDTO.setQuestion(question.getQuestion());

//         if (question.getAnswer() != null) {
//             questionDTO.setAnswer(question.getAnswer().getAnswer());
//         }

//         return questionDTO;
//     }

//     public Question toQuestionEntity(QuestionDto questionDTO) {
//         Question question = new Question();
//         question.setId(questionDTO.getId());
//         question.setStudentName(questionDTO.getStudentName());
//         question.setQuestion(questionDTO.getQuestion());

//         if (questionDTO.getAnswer() != null) {
//             Answer answer = new Answer();
//             answer.setAnswer(questionDTO.getAnswer());
//             question.setAnswer(answer);
//         }

//         return question;
//     }

//     public String toAnswerDTO(Answer answer) {
//         if (answer != null) {
//             return answer.getAnswer();
//         }
//         return null;
//     }

//     public Answer toAnswerEntity(String answer) {
//         if (answer != null) {
//             Answer answerEntity = new Answer();
//             answerEntity.setAnswer(answer);
//             return answerEntity;
//         }
//         return null;
//     }
// }