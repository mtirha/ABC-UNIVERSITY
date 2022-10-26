package edu.miu.assessmentservice.service;



import edu.miu.assessmentservice.domain.entity.Course;
import edu.miu.dto.CourseDto;
import org.springframework.stereotype.Service;


@Service
public interface ICourseService {

	Course handleRecord(CourseDto courseDto);

}














