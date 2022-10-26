package edu.miu.registrarservice.service;


import edu.miu.dto.StudentDto;
import edu.miu.registrarservice.domain.Student;
import org.springframework.stereotype.Service;


@Service
public interface IStudentService {

	Student handleRecord(StudentDto studentDto);

}














