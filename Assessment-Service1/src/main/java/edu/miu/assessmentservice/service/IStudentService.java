package edu.miu.assessmentservice.service;


import edu.miu.dto.StudentDto;
import edu.miu.assessmentservice.domain.entity.Student;
import org.springframework.stereotype.Service;


@Service
public interface IStudentService {

	Student handleRecord(StudentDto studentDto);

}














