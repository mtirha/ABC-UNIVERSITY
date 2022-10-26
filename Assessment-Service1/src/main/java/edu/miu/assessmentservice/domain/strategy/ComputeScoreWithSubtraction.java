package edu.miu.assessmentservice.domain.strategy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("ComputeScoreWithSubtraction")
public class ComputeScoreWithSubtraction extends ComputeScore  {

    public ComputeScoreWithSubtraction() {
    }

    @Override
    public double computeScore() {
        if(question.getStudentAnswers().size() == 0)
            return 0;
        List<String> studentAnswers = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        question.getStudentAnswers().forEach(q -> studentAnswers.add(q));
        question.getCorrectAnswers().forEach(q -> correctAnswers.add(q));

        correctAnswers.removeAll(question.getStudentAnswers());
        studentAnswers.removeAll(question.getCorrectAnswers());

        if(correctAnswers.size() == 0 && studentAnswers.size() == 0)
            return question.getTotalScore();
        else if(correctAnswers.size() == 0 && studentAnswers.size() != 0)
            return question.getTotalScore() - studentAnswers.size();
        else if(correctAnswers.size() != 0 && studentAnswers.size() == 0)
            return question.getTotalScore() - correctAnswers.size();
        else if(correctAnswers.size() != 0 && studentAnswers.size() != 0)
            return question.getTotalScore() - correctAnswers.size();
        else
            return 0;
    }
}
