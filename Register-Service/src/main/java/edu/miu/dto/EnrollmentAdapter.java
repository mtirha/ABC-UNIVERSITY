package edu.miu.dto;


import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.domain.Enrollment;

public class EnrollmentAdapter {

    public static EnrollmentDto toEnrollmentDto(Enrollment enrollment) {
        EnrollmentDto enrollmentDto = new EnrollmentDto();
        if(enrollment != null){
            enrollmentDto.setId(enrollment.getId());
            enrollmentDto.setEnrollNumber(enrollment.getEnrollNumber());
            enrollmentDto.setCourseOfferingDto(CourseOfferingAdapter.toCourseOfferingDto(enrollment.getCourseOffering()));
            enrollmentDto.setStudentDto(StudentAdapter.toStudentDto(enrollment.getStudent()));
        }
        return enrollmentDto;
    }
}
