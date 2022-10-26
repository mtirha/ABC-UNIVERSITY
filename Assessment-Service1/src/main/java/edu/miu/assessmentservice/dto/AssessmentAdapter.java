package edu.miu.assessmentservice.dto;


import edu.miu.assessmentservice.domain.entity.Assessment;
import edu.miu.assessmentservice.domain.enums.AssessmentType;


public class AssessmentAdapter {

    public static Assessment toAssessment(AssessmentDto assessmentDto) {
        Assessment assessment = new Assessment();
        if(assessmentDto != null){
            assessment.setAssessNumber(assessmentDto.getAssessNumber());
            assessment.setTitle(assessmentDto.getTitle());
            assessment.setAssessmentType(AssessmentType.valueOf(assessmentDto.getAssessmentType()));
            assessment.setPercentage(assessmentDto.getPercentage());
            assessment.setCreationDate(assessmentDto.getCreationDate());
            assessment.setDueDate(assessmentDto.getDueDate());
            assessment.setOpenDate(assessmentDto.getOpenDate());
            assessment.setQuestions(QuestionAdapter.toListQuestion(assessmentDto.getQuestionDtos()));
        }
        return assessment;
    }

    public static AssessmentDto toAssessmentDto(Assessment assessment) {
        AssessmentDto assessmentDto = new AssessmentDto();
        if(assessment != null){
            assessmentDto.setAssessNumber(assessment.getAssessNumber());
            assessmentDto.setTitle(assessment.getTitle());
            assessmentDto.setAssessmentType(assessment.getAssessmentType().getType());
            assessmentDto.setPercentage(assessment.getPercentage());
            assessmentDto.setCreationDate(assessment.getCreationDate());
            assessmentDto.setDueDate(assessment.getDueDate());
            assessmentDto.setOpenDate(assessment.getOpenDate());
            assessmentDto.setQuestionDtos(QuestionAdapter.toListQuestionDto(assessment.getQuestions()));
        }
        return assessmentDto;
    }

}
