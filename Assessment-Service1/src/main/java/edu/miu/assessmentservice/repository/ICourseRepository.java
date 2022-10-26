package edu.miu.assessmentservice.repository;


import edu.miu.assessmentservice.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseNumber(String courseNumber);

}
