package edu.miu.dto;


import edu.miu.assessmentservice.domain.entity.CourseOffering;

public class CourseOfferingAdapter {

    public static CourseOffering toCourseOffering(CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = new CourseOffering();
        if(courseOfferingDto != null){
            courseOffering.setId(courseOfferingDto.getId());
            courseOffering.setOfferNumber(courseOfferingDto.getOfferNumber());
            courseOffering.setCourse(CourseAdapter.toCourse(courseOfferingDto.getCourseDto()));
            courseOffering.setFaculty(FacultyAdapter.toFaculty(courseOfferingDto.getFacultyDto()));
//            courseOffering.setEnrollments(FacultyAdapter.toFaculty(courseOfferingDto.getEnrollmentDtos()));
        }
        return courseOffering;
    }
}
