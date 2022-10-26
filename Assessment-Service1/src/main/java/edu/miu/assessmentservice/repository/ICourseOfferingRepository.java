package edu.miu.assessmentservice.repository;

import edu.miu.assessmentservice.domain.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseOfferingRepository extends JpaRepository<CourseOffering, Long> {

    CourseOffering findByOfferNumber(String offerNumber);
}
