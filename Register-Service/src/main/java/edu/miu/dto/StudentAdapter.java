package edu.miu.dto;


import edu.miu.registrarservice.domain.Student;

public class StudentAdapter {


    public static Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        if(studentDto != null){
            student.setId(studentDto.getId());
            student.setStudentNumber(studentDto.getStudentNumber());
            student.setStudentName(studentDto.getStudentName());
        }
        return student;
    }

    public static StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        if(student != null){
            studentDto.setId(student.getId());
            studentDto.setStudentNumber(student.getStudentNumber());
            studentDto.setStudentName(student.getStudentName());
        }
        return studentDto;
    }

}
