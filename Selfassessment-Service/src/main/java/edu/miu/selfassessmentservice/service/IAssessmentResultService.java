package edu.miu.selfassessmentservice.service;


import edu.miu.selfassessmentservice.domain.Answer;
import edu.miu.selfassessmentservice.domain.AssessmentResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAssessmentResultService {
    public void save(String studentNumber, List<Answer> studentAnswers);
    public AssessmentResult getResultForStudent(String studentNumber);
}
