package edu.miu.adminservice.service;

import edu.miu.adminservice.entity.Registrar;
import edu.miu.dto.StudentAdapter;
import edu.miu.dto.StudentDto;
import edu.miu.adminservice.entity.Student;
import edu.miu.adminservice.integration.StudentSender;
import edu.miu.adminservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService  implements IUserService<Student>  {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentSender studentSender;

    public Student add(Student student) {
        String lastNumber = studentRepository.findLastUserNumber();
        String  number = Student.GenerateNumber(lastNumber, "stu");
        student.setUserNumber(number);
        studentRepository.save(student);

        StudentDto studentDto = StudentAdapter.toStudentDto(student);
        studentSender.send(studentDto);

        return student;
    }
    public Student update(String userNumber, Student faculty) {
        Student updated = studentRepository.findByUserNumber(userNumber);
        if(faculty != null){
            updated.setAdmissionDate(faculty.getAdmissionDate());
            updated.setDob(faculty.getDob());
            updated.setAddress(faculty.getAddress());
            updated.setEmail(faculty.getEmail());
            updated.setFirstName(faculty.getFirstName());
            updated.setPhone_number(faculty.getPhone_number());
            updated.setLastName(faculty.getLastName());
            studentRepository.save(updated);

            StudentDto studentDto = StudentAdapter.toStudentDto(updated);
            studentSender.send(studentDto);
        }
        return updated;
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    public Student getByUserNumber(String userNumber) {
        return studentRepository.findByUserNumber(userNumber);
    }

}














