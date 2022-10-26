package edu.miu.registrarservice.service;

import edu.miu.registrarservice.domain.Course;
import edu.miu.registrarservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICourseService {


    Course add(Course course) ;
    Course update(String courseNumber, Course course) ;
    List<Course> getAll() ;
    Optional<Course> getOne(long id) ;
    Course getByCourseNumber(String courseNumber) ;
}
