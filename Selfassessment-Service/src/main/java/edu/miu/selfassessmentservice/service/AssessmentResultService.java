package edu.miu.selfassessmentservice.service;



import edu.miu.selfassessmentservice.domain.*;
import edu.miu.selfassessmentservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AssessmentResultService implements IAssessmentResultService {

    @Autowired
    private IAssessmentResultRepo assessmentResultRepo;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(String studentNumber, List<Answer> studentAnswers) {
        AssessmentResult assessmentResult = new AssessmentResult();
        Student student = studentRepository.findByStudentNumber(studentNumber);
        assessmentResult.setStudent(student);
        assessmentResult.setStudentAnswers(studentAnswers);
        assessmentResult.calculateScore();
        assessmentResultRepo.save(assessmentResult);
    }

    @Override
    public AssessmentResult getResultForStudent(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber);
        return assessmentResultRepo.getAssessmentResultByStudent(student);
    }
}
