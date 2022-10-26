package edu.miu.assessmentservice.domain.enums;

public enum AssessmentType {

    ASSIGNMENT("A"), QUIZ("Q"), MIDTERM("M"), FINAL("F");

    private String type;

    AssessmentType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
