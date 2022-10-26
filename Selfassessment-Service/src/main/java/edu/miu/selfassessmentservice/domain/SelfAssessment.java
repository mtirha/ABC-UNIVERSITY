package edu.miu.selfassessmentservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelfAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate dateGenerated;
    private LocalDate dueDate;
    @OneToMany
    private List<Question> questions;
    @OneToMany
    private List<AssessmentResult> assessmentResults;
}
