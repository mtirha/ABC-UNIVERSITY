package edu.miu.registrarservice.service;

import edu.miu.dto.CourseAdapter;
import edu.miu.dto.CourseDto;
import edu.miu.registrarservice.domain.Course;
import edu.miu.registrarservice.integration.CourseSender;
import edu.miu.registrarservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseSender courseSender;

    public Course add(Course course) {
        courseRepository.save(course);

        CourseDto courseDto = CourseAdapter.toCourseDto(course);
        courseSender.send(courseDto);

        return course;
    }
    public Course update(String courseNumber, Course course) {
        Course updated = courseRepository.findByCourseNumber(courseNumber);
        if(updated != null){
            updated.setTitle(course.getTitle());
            updated.setCredit(course.getCredit());
            updated.setObservation(course.getObservation());
            updated.setLevel(course.getLevel());
            courseRepository.save(updated);

            CourseDto courseDto = CourseAdapter.toCourseDto(updated);
            courseSender.send(courseDto);
        }
        return updated;
    }
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
    public Optional<Course> getOne(long id) {
        return courseRepository.findById(id);
    }
    public Course getByCourseNumber(String courseNumber) {
        return courseRepository.findByCourseNumber(courseNumber);
    }
}
