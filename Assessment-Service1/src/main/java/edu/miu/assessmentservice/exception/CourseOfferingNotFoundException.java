package edu.miu.assessmentservice.exception;

public class CourseOfferingNotFoundException extends Exception {

    public CourseOfferingNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public String getErrorMessage() {
        return super.getMessage();
    }

}
