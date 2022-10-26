package edu.miu.assessmentservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AssessmentTypeValidator.class)
public @interface AssessmentType {

    String message() default "This assessment type is not valid";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
