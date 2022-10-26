package edu.miu.dto;


import edu.miu.assessmentservice.domain.entity.Enrollment;

public class EnrollmentAdapter {

    public static Enrollment toEnrollment(EnrollmentDto enrollmentDto) {
        Enrollment enrollment = new Enrollment();
        if(enrollmentDto != null){
            enrollment.setId(enrollmentDto.getId());
            enrollment.setEnrollNumber(enrollmentDto.getEnrollNumber());
            enrollment.setCourseOffering(CourseOfferingAdapter.toCourseOffering(enrollmentDto.getCourseOfferingDto()));
            enrollment.setStudent(StudentAdapter.toStudent(enrollmentDto.getStudentDto()));
        }
        return enrollment;
    }
}
