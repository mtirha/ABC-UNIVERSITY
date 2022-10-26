package edu.miu.dto;


import edu.miu.registrarservice.domain.Course;
import edu.miu.registrarservice.domain.CourseOffering;

public class CourseOfferingAdapter {

    public static CourseOfferingDto toCourseOfferingDto(CourseOffering courseOffering) {
        CourseOfferingDto courseOfferingDto = new CourseOfferingDto();
        if(courseOffering != null){
            courseOfferingDto.setId(courseOffering.getId());
            courseOfferingDto.setOfferNumber(courseOffering.getOfferNumber());
            courseOfferingDto.setCourseDto(CourseAdapter.toCourseDto(courseOffering.getCourse()));
            courseOfferingDto.setFacultyDto(FacultyAdapter.toFacultyDto(courseOffering.getFaculty()));
        }
        return courseOfferingDto;
    }
}
