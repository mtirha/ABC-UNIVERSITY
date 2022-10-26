package edu.miu.registrarservice.repository;

import edu.miu.registrarservice.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseNumber(String courseNumber);

}
