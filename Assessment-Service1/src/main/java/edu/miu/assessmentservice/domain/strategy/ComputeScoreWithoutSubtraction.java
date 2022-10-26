package edu.miu.assessmentservice.domain.strategy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("ComputeScoreWithoutSubtraction")
public class ComputeScoreWithoutSubtraction extends ComputeScore {

    public ComputeScoreWithoutSubtraction() {
    }

    @Override
    public double computeScore() {
        List<String> correctAnswers = question.getCorrectAnswers();
        correctAnswers.removeAll(question.getStudentAnswers());
        return question.getTotalScore() - correctAnswers.size();
    }
}
