package edu.miu.assessmentservice.service;

import edu.miu.assessmentservice.dto.AssessmentDto;
import edu.miu.assessmentservice.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface IAssessmentService {

//    AssessmentDto update(AssessmentDto assessmentDto);
//    void delete(String assessNumber);
    List<AssessmentDto> findByAssessNumber(String assessNumber);
    Collection<AssessmentDto> findAll();
    AssessmentDto create(String offerNumber, String title, String assessmentType, double percentage, List<QuestionDto> questions);
    List<String> takeAssessment(String enrollNumber, String assessNumber, String questNumber, List<String> studentAnswers);
}
