package edu.miu.assessmentservice.repository;

import edu.miu.assessmentservice.domain.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAssessmentRepository extends JpaRepository<Assessment, Long> {

    List<Assessment> findByAssessNumber(String assessNumber);

    @Query(value = "select max(assess_number) from assessment", nativeQuery = true)
    String findLastAssessmentNumber();

    @Query(value = "select * from assessment where assess_number = :assess_number and  enrollment_id = :enrollID", nativeQuery = true)
    Assessment findByAssessNumberAndEnrollmentNumber(@Param("assess_number") String assess_number, @Param("enrollID") Long enrollID);
}
