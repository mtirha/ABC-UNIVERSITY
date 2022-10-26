package edu.miu.assessmentservice.service;


import edu.miu.assessmentservice.domain.entity.Course;
import edu.miu.assessmentservice.domain.entity.CourseOffering;
import edu.miu.assessmentservice.repository.ICourseOfferingRepository;
import edu.miu.dto.CourseAdapter;
import edu.miu.dto.CourseDto;
import edu.miu.dto.CourseOfferingAdapter;
import edu.miu.dto.CourseOfferingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseOfferingService implements ICourseOfferingService {

	@Autowired
	private ICourseOfferingRepository courseOfferingRepository;

	@Override
	public CourseOffering handleRecord(CourseOfferingDto courseOfferingDto) {
		CourseOffering courseOffering = CourseOfferingAdapter.toCourseOffering(courseOfferingDto);
		CourseOffering updated = courseOfferingRepository.findByOfferNumber(courseOffering.getOfferNumber());
		if(updated != null)
			courseOfferingRepository.save(updated);
		else
			courseOfferingRepository.save(courseOffering);
		return courseOffering;
	}
    @Override
    public CourseOffering findByOfferNumber(String offerNumber){
        CourseOffering courseOffering = courseOfferingRepository.findByOfferNumber(offerNumber);
        return courseOffering;
    }

}














