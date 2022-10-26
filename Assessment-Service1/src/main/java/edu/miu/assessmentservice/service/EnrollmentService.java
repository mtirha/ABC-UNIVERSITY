package edu.miu.assessmentservice.service;

import edu.miu.assessmentservice.domain.entity.CourseOffering;
import edu.miu.assessmentservice.domain.entity.Enrollment;
import edu.miu.assessmentservice.repository.ICourseOfferingRepository;
import edu.miu.assessmentservice.repository.IEnrollmentRepository;
import edu.miu.dto.CourseOfferingAdapter;
import edu.miu.dto.CourseOfferingDto;
import edu.miu.dto.EnrollmentAdapter;
import edu.miu.dto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private ICourseOfferingRepository courseOfferingRepository;

    @Autowired
    private IEnrollmentRepository enrollmentRepository;


    @Override
    public Enrollment handleRecord(EnrollmentDto enrollmentDto) {
        Enrollment enrollment = EnrollmentAdapter.toEnrollment(enrollmentDto);
        Enrollment updated = enrollmentRepository.findByEnrollNumber(enrollment.getEnrollNumber());
        if(updated != null)
            enrollmentRepository.save(updated);
        else
            enrollmentRepository.save(enrollment);
        return enrollment;
    }

    @Override
    public void updateGrades(String offerNumber){
        CourseOffering courseOffering = courseOfferingRepository.findByOfferNumber(offerNumber);
        for (Enrollment enrollment :  courseOffering.getEnrollments()){
            enrollment.computeGrade();
            enrollmentRepository.save(enrollment);
        }
    }

    @Override
    public Map<String, String> getAllGrades(String offerNumber){
        Map<String, String> map = new HashMap<>();
        CourseOffering courseOffering = courseOfferingRepository.findByOfferNumber(offerNumber);
        DecimalFormat df = new DecimalFormat("0.00");
        for (Enrollment enrollment :  courseOffering.getEnrollments()){
            map.put(enrollment.getStudent().getStudentName(), df.format(enrollment.getGrade() * 100));
        }
        return map;
    }

}
