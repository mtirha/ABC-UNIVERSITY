package edu.miu.dto;


import edu.miu.registrarservice.domain.Course;

public class CourseAdapter {

    public static CourseDto toCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        if(course != null){
            courseDto.setId(course.getId());
            courseDto.setCourseNumber(course.getCourseNumber());
            courseDto.setCourseName(course.getTitle());
        }
        return courseDto;
    }
}
