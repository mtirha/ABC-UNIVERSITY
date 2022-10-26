package edu.miu.registrarservice.service;


import edu.miu.dto.FacultyAdapter;
import edu.miu.dto.StudentAdapter;
import edu.miu.dto.StudentDto;
import edu.miu.registrarservice.domain.Faculty;
import edu.miu.registrarservice.domain.Student;
import edu.miu.registrarservice.repository.FacultyRepository;
import edu.miu.registrarservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student handleRecord(StudentDto studentDto) {
		Student student = StudentAdapter.toStudent(studentDto);
		Student updated = studentRepository.findByStudentNumber(student.getStudentNumber());
		if(updated != null){
			updated.setStudentName(student.getStudentName());
			studentRepository.save(updated);
		}else{
			studentRepository.save(student);
		}
		return student;
	}



}














