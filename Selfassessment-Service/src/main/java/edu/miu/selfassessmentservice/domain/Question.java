package edu.miu.selfassessmentservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private String category;
    private String subcategory;
    private int points;
    private String correctAnswer;

    @ElementCollection
    private List<String> incorrectAnswers;
}
