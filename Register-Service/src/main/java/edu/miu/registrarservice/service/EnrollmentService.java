package edu.miu.registrarservice.service;


import edu.miu.dto.EnrollmentAdapter;
import edu.miu.dto.EnrollmentDto;
import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.domain.Enrollment;
import edu.miu.registrarservice.integration.EnrollmentSender;
import edu.miu.registrarservice.repository.CourseOfferingRepository;
import edu.miu.registrarservice.repository.EnrollmentRepository;
import edu.miu.registrarservice.domain.Student;
import edu.miu.registrarservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService implements IEnrollmentService{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Autowired
    private EnrollmentSender enrollmentSender;

    public Enrollment create(String offerNumber, String studentNumber, Enrollment enrollment) {
        CourseOffering courseOffering = courseOfferingRepository.findByOfferNumber(offerNumber);
        Student student = studentRepository.findByStudentNumber(studentNumber);
        enrollment.setCourseOffering(courseOffering);
        enrollment.setStudent(student);
        enrollmentRepository.save(enrollment);

        EnrollmentDto enrollmentDto = EnrollmentAdapter.toEnrollmentDto(enrollment);
        enrollmentSender.send(enrollmentDto);

        return enrollment;
    }
    public Enrollment update(String enrollNumber, Enrollment enrollment) {
        Enrollment updated = enrollmentRepository.findByEnrollNumber(enrollNumber);
        if(updated != null){
            updated.setStudent(enrollment.getStudent());
            updated.setCourseOffering(enrollment.getCourseOffering());
            updated.setGrade(enrollment.getGrade());
            updated.setStatus(enrollment.getStatus());
            enrollmentRepository.save(enrollment);

            EnrollmentDto enrollmentDto = EnrollmentAdapter.toEnrollmentDto(updated);
            enrollmentSender.send(enrollmentDto);
        }
        return updated;
    }
    public List<Enrollment> getAllByStudent(String studentNumber) {
        return enrollmentRepository.getAllByStudent(studentNumber);
    }
    public Optional<Enrollment> getOne(long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Enrollment getByEnrollNumberr(String enrollNumber) {
        return enrollmentRepository.findByEnrollNumber(enrollNumber);
    }
}
