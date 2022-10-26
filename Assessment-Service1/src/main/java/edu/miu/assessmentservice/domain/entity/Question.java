package edu.miu.assessmentservice.domain.entity;

import edu.miu.assessmentservice.domain.strategy.ComputeScore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Question  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questNumber;
    private String label;
    private double totalScore;
    private double studentScore;

    @ElementCollection
    private List<String> correctAnswers;
    @ElementCollection
    private List<String> incorrectAnswers;
    @ElementCollection
    private List<String> studentAnswers;

    @Transient
    private ComputeScore calculator;

    public Question() {
        this.correctAnswers = new ArrayList<>();
        this.incorrectAnswers = new ArrayList<>();
        this.studentAnswers = new ArrayList<>();
    }

    public double computeScore() {
        return calculator.computeScore();
    }
}
