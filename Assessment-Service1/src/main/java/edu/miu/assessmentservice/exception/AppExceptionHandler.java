package edu.miu.assessmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorApi handleInvalidArgument(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ErrorApi error = new ErrorApi(400, exception.getMessage(), request.getServletPath());
        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        bindingResult.getFieldErrors().forEach(e -> {
            errors.put(e.getField(), e.getDefaultMessage());
        });
        error.setValidationErrors(errors);
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AssessmentNotFoundException.class)
    public Map<String, String> handleAssessment(AssessmentNotFoundException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("messageError", exception.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CourseOfferingNotFoundException.class)
    public Map<String, String> handleCourseOffering(CourseOfferingNotFoundException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("messageError", exception.getMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAll(Exception exception, HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        errors.put("path", request.getServletPath());
        errors.put("messageError", exception.getMessage());
        return errors;
    }
}
