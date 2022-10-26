package edu.miu.assessmentservice.dto;




import edu.miu.assessmentservice.validation.AssessmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AssessmentDto {

    @NotBlank(message = "{AssessmentDto.assessNumber}")
    private String assessNumber;

    @NotBlank(message = "{AssessmentDto.title}")
    private String title;

    @AssessmentType
    private String assessmentType;

    @Min(0)
    @Max(1)
    private double percentage;

    @PastOrPresent
    private LocalDateTime creationDate;

    @FutureOrPresent
    private LocalDateTime openDate;

    @FutureOrPresent
    private LocalDateTime dueDate;

    @NotEmpty(message = "{AssessmentDto.questionDtos}")
    private List<@Valid QuestionDto> questionDtos;

}
