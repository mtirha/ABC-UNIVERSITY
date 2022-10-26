package edu.miu.assessmentservice.dto;


import edu.miu.assessmentservice.domain.entity.Question;

import java.util.ArrayList;
import java.util.List;


public class QuestionAdapter {

    public static List<Question> toListQuestion(List<QuestionDto> questionDtos) {
        List<Question> questions = new ArrayList<>();
        questionDtos.stream().forEach(questionDto -> questions.add(toQuestion(questionDto)));
        return questions;
    }
    public static List<QuestionDto> toListQuestionDto(List<Question> questions) {
        List<QuestionDto> questionDtos = new ArrayList<>();
        questions.stream().forEach(question -> questionDtos.add(toQuestionDto(question)));
        return questionDtos;
    }
    public static Question toQuestion(QuestionDto questionDto) {
        Question question = new Question();
        if(questionDto != null){
            question.setQuestNumber(questionDto.getQuestNumber());
            question.setLabel(questionDto.getLabel());
            question.setTotalScore(questionDto.getTotalScore());
            question.setStudentScore(questionDto.getStudentScore());
            questionDto.getCorrectAnswers().stream().forEach(answer -> question.getCorrectAnswers().add(answer));
            questionDto.getIncorrectAnswers().stream().forEach(answer -> question.getIncorrectAnswers().add(answer));
        }
        return question;
    }

    public static QuestionDto toQuestionDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        if(question != null){
            questionDto.setQuestNumber(question.getQuestNumber());
            questionDto.setLabel(question.getLabel());
            questionDto.setTotalScore(question.getTotalScore());
            questionDto.setStudentScore(question.getStudentScore());
//            question.getStudentAnswers().stream().forEach(answer -> questionDto.getStudentAnswers().add(answer));
            question.getCorrectAnswers().stream().forEach(answer -> questionDto.getCorrectAnswers().add(answer));
            question.getIncorrectAnswers().stream().forEach(answer -> questionDto.getIncorrectAnswers().add(answer));
        }
        return questionDto;
    }

}
