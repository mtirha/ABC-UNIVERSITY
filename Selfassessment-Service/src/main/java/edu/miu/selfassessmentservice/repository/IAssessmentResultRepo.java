package edu.miu.selfassessmentservice.repository;


import edu.miu.selfassessmentservice.domain.AssessmentResult;
import edu.miu.selfassessmentservice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssessmentResultRepo extends JpaRepository<AssessmentResult, Long> {
    public AssessmentResult getAssessmentResultByStudent(Student student);
}
