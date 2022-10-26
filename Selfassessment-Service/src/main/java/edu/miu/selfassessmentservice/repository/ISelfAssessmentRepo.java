package edu.miu.selfassessmentservice.repository;


import edu.miu.selfassessmentservice.domain.SelfAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISelfAssessmentRepo extends JpaRepository<SelfAssessment, Long> {

}
