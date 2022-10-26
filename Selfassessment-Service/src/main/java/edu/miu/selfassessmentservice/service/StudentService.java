package edu.miu.selfassessmentservice.service;


import edu.miu.dto.StudentAdapter;
import edu.miu.dto.StudentDto;
import edu.miu.selfassessmentservice.domain.Student;
import edu.miu.selfassessmentservice.repository.StudentRepository;
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














