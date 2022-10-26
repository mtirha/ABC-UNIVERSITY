package edu.miu.assessmentservice.domain.service;

import edu.miu.assessmentservice.domain.entity.Assessment;
import edu.miu.assessmentservice.domain.entity.Question;
import edu.miu.assessmentservice.domain.strategy.ComputeScore;

import java.util.List;


public class TakeAssessmentService  {

    private ComputeScore calculator;

    public TakeAssessmentService(ComputeScore calculator) {
        this.calculator = calculator;
    }

    public void takeAssessment(String questNumber, List<String> studentAnswers, Assessment assessment) {
        for(Question q : assessment.getQuestions()){
            q.setCalculator(calculator);
            calculator.setQuestion(q);
            if(q.getQuestNumber().equals(questNumber)){
                for(String s : studentAnswers){
                    q.getStudentAnswers().add(s);
                    double score = q.computeScore();
                    q.setStudentScore(score);
                }
            }
        }
    }



}
