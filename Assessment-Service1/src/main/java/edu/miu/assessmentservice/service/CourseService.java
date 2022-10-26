package edu.miu.assessmentservice.service;



import edu.miu.assessmentservice.domain.entity.Course;
import edu.miu.assessmentservice.repository.ICourseRepository;
import edu.miu.dto.CourseAdapter;
import edu.miu.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService implements ICourseService {

	@Autowired
	private ICourseRepository courseRepository;

	@Override
	public Course handleRecord(CourseDto courseDto) {
		Course course = CourseAdapter.toCourse(courseDto);
		Course updated = courseRepository.findByCourseNumber(course.getCourseNumber());
		if(updated != null){
			updated.setCourseName(course.getCourseName());
			courseRepository.save(updated);
		}
		else
			courseRepository.save(course);
		return course;
	}

}














