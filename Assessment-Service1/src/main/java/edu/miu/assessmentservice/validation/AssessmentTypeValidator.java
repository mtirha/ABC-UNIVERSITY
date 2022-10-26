package edu.miu.assessmentservice.validation;

import edu.miu.assessmentservice.dto.AssessmentDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AssessmentTypeValidator implements ConstraintValidator<AssessmentType, AssessmentDto> {


    @Override
    public boolean isValid(AssessmentDto value, ConstraintValidatorContext context) {
        if(value.getAssessmentType().equals("A"))
            return true;
        if(value.getAssessmentType().toUpperCase().equals("Q"))
            return true;
        if(value.getAssessmentType().toUpperCase().equals("M"))
            return true;
        if(value.getAssessmentType().toUpperCase().equals("F"))
            return true;
        return false;
    }

}
