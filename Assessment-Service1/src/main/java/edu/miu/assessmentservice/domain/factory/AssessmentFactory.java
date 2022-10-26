package edu.miu.assessmentservice.domain.factory;

import edu.miu.assessmentservice.domain.entity.Assessment;
import edu.miu.assessmentservice.domain.entity.Question;
import edu.miu.assessmentservice.domain.enums.AssessmentType;

import java.util.List;

public class AssessmentFactory {

    public static Assessment assessmentFactory(String  title, AssessmentType assessmentType, double percentage, List<Question> questions, int delayDueDate){
        Assessment assessment = new Assessment(title, assessmentType, percentage, delayDueDate);
        AssessmentFactory.addAllQuestions(questions, assessment);
        return assessment;
    }

    private static void addAllQuestions(List<Question> questions, Assessment assessment){
        int number = 1;
        for(Question q : questions){
            q.setQuestNumber(String.valueOf(number++));
            assessment.getQuestions().add(q);
        }
    }
}
