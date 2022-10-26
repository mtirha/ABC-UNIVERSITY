package edu.miu.assessmentservice.service;

import edu.miu.assessmentservice.domain.entity.Enrollment;
import edu.miu.dto.EnrollmentDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IEnrollmentService {

    Enrollment handleRecord(EnrollmentDto enrollmentDto);
    void updateGrades(String offerNumber);
    Map<String, String> getAllGrades(String offerNumber);

}
