package edu.miu.assessmentservice.repository;

import edu.miu.assessmentservice.domain.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Enrollment findByEnrollNumber(String enrollNumber);
}
