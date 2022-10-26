package edu.miu.assessmentservice.service;

import edu.miu.assessmentservice.domain.entity.Assessment;
import edu.miu.assessmentservice.domain.entity.CourseOffering;
import edu.miu.assessmentservice.domain.entity.Enrollment;
import edu.miu.assessmentservice.domain.enums.AssessmentType;
import edu.miu.assessmentservice.domain.factory.AssessmentFactory;
import edu.miu.assessmentservice.domain.service.TakeAssessmentService;
import edu.miu.assessmentservice.domain.strategy.ComputeScore;
import edu.miu.assessmentservice.dto.AssessmentAdapter;
import edu.miu.assessmentservice.dto.AssessmentDto;
import edu.miu.assessmentservice.dto.QuestionAdapter;
import edu.miu.assessmentservice.dto.QuestionDto;
import edu.miu.assessmentservice.repository.IAssessmentRepository;
import edu.miu.assessmentservice.repository.ICourseOfferingRepository;
import edu.miu.assessmentservice.repository.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AssessmentService implements IAssessmentService {

    @Value("${delayDueDate}")
    public int delayDueDate;

    @Autowired
    private ComputeScore calculator;

    @Autowired
    private IAssessmentRepository assessmentRepository;
    @Autowired
    private ICourseOfferingRepository courseOfferingRepository;
    @Autowired
    private IEnrollmentRepository enrollmentRepository;

    public List<AssessmentDto> findByAssessNumber(String assessNumber){
        List<Assessment> assessments = assessmentRepository.findByAssessNumber(assessNumber);
        List<AssessmentDto> assessmentDtos = new ArrayList<>();
        for(Assessment a : assessments)
            assessmentDtos.add(AssessmentAdapter.toAssessmentDto(a));
        return assessmentDtos;
    }

    public Collection<AssessmentDto> findAll(){
        Collection<Assessment> assessments = assessmentRepository.findAll();
        Collection<AssessmentDto> assessmentDtos = new ArrayList<AssessmentDto>();
        assessments.stream().forEach(assessment -> assessmentDtos.add(AssessmentAdapter.toAssessmentDto(assessment)));
        return assessmentDtos;
    }

    public AssessmentDto create(String offerNumber, String title, String assessmentType, double percentage, List<QuestionDto> questions){
        CourseOffering courseOffering = courseOfferingRepository.findByOfferNumber(offerNumber);
        String lastNumber = assessmentRepository.findLastAssessmentNumber();
        Assessment assessment = null;
        String assessNumber = Assessment.GenerateNumber(lastNumber);
        for (Enrollment e :  courseOffering.getEnrollments()){
            assessment = AssessmentFactory.assessmentFactory(title, AssessmentType.valueOf(assessmentType), percentage, QuestionAdapter.toListQuestion(questions), delayDueDate);
            assessment.setAssessNumber(assessNumber);
            e.getAssessments().add(assessment);
            assessmentRepository.save(assessment);
        }
        return AssessmentAdapter.toAssessmentDto(assessment);
    }

    public List<String> takeAssessment(String enrollNumber, String assessNumber, String questNumber, List<String> studentAnswers){
        Enrollment enrollment = enrollmentRepository.findByEnrollNumber(enrollNumber);
        Assessment assessment = assessmentRepository.findByAssessNumberAndEnrollmentNumber(assessNumber, enrollment.getId());
        TakeAssessmentService service = new TakeAssessmentService(calculator);
        service.takeAssessment(questNumber,  studentAnswers, assessment);
        assessmentRepository.save(assessment);
        return studentAnswers;
    }

}
