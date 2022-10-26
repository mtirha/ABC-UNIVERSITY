package edu.miu.assessmentservice.dto;


import java.util.Collection;
import java.util.List;


public class AssessmentDtos {

    private Collection<AssessmentDto> assessmentDtos;

    public AssessmentDtos(Collection<AssessmentDto> assessmentDtos) {
        this.assessmentDtos = assessmentDtos;
    }
    public Collection<AssessmentDto> getAssessments() {
        return this.assessmentDtos;
    }
    public void setAssessments(List<AssessmentDto> assessmentDtos) {
        this.assessmentDtos = assessmentDtos;
    }
}
