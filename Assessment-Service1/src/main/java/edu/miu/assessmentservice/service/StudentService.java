package edu.miu.assessmentservice.service;


import edu.miu.assessmentservice.repository.IStudentRepository;
import edu.miu.dto.StudentAdapter;
import edu.miu.dto.StudentDto;
import edu.miu.assessmentservice.domain.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

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














