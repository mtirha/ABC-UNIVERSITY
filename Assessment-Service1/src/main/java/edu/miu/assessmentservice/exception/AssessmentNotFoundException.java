package edu.miu.assessmentservice.exception;

public class AssessmentNotFoundException extends Exception {

    public AssessmentNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public String getErrorMessage() {
        return super.getMessage();
    }

}
