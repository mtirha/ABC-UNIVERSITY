package edu.miu.selfassessmentservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AssessmentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Student student;

    @OneToMany
    private List<Answer> studentAnswers;

    private int studentScore;

    public int calculateScore() {
        int score = 0;

        for (Answer answer: studentAnswers) {
            Question currentQuestion = answer.getQuestion();
            if (answer.getStudentAnswer().equals(currentQuestion.getCorrectAnswer())) {
                score += currentQuestion.getPoints();
            }
        }
        return score;
    }
}
