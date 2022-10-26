package edu.miu.registrarservice.service;


import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.domain.Enrollment;
import edu.miu.registrarservice.domain.Student;
import edu.miu.registrarservice.repository.CourseOfferingRepository;
import edu.miu.registrarservice.repository.EnrollmentRepository;
import edu.miu.registrarservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IEnrollmentService {

    Enrollment create(String offerNumber, String studentNumber, Enrollment enrollment) ;
    Enrollment update(String enrollNumber, Enrollment enrollment) ;
    List<Enrollment> getAllByStudent(String studentNumber) ;
    Optional<Enrollment> getOne(long id) ;
    Enrollment getByEnrollNumberr(String enrollNumber) ;

}
