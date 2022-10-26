package edu.miu.assessmentservice.service;



import edu.miu.assessmentservice.domain.entity.Course;
import edu.miu.assessmentservice.domain.entity.CourseOffering;
import edu.miu.dto.CourseOfferingDto;
import org.springframework.stereotype.Service;


@Service
public interface ICourseOfferingService {

	CourseOffering handleRecord(CourseOfferingDto courseOfferingDto);
	CourseOffering findByOfferNumber(String offerNumber);
}














