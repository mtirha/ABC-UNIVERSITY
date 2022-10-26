package edu.miu.assessmentservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class QuestionDto {

    @NotBlank(message = "{QuestionDto.questNumber}")
    private String questNumber;

    @NotBlank(message = "{QuestionDto.label}")
    private String label;

    @Min(value = 1, message = "the question score should be be at least {value}")
    @Max(value = 10, message = "the question score should be be at most {value}")
    private double totalScore;

    private double studentScore;

    @NotNull
    private List<@NotBlank(message = "{QuestionDto.correctAnswers}") String> correctAnswers ;

    @NotNull
    private List<@NotBlank(message = "{QuestionDto.incorrectAnswers}") String> incorrectAnswers ;

    private List<String> studentAnswers;

    public QuestionDto() {
        this.correctAnswers = new ArrayList<>();
        this.incorrectAnswers = new ArrayList<>();
        this.studentAnswers = new ArrayList<>();
    }
}
