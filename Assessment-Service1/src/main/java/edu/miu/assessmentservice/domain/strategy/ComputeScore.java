package edu.miu.assessmentservice.domain.strategy;

import edu.miu.assessmentservice.domain.entity.Question;
import org.springframework.stereotype.Component;


@Component
public abstract class ComputeScore {

    protected Question question;

    public ComputeScore() {
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public abstract double computeScore() ;

}
