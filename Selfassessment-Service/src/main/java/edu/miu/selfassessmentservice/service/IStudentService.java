package edu.miu.selfassessmentservice.service;


import edu.miu.dto.StudentDto;
import edu.miu.selfassessmentservice.domain.Student;
import org.springframework.stereotype.Service;


@Service
public interface IStudentService {

	Student handleRecord(StudentDto studentDto);

}














