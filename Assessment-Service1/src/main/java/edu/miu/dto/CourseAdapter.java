package edu.miu.dto;


import edu.miu.assessmentservice.domain.entity.Course;

public class CourseAdapter {

    public static Course toCourse(CourseDto courseDto) {
        Course course = new Course();
        if(courseDto != null){
            course.setId(courseDto.getId());
            course.setCourseName(courseDto.getCourseName());
            course.setCourseNumber(courseDto.getCourseNumber());
        }
        return course;
    }
}
