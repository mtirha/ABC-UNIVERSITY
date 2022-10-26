package edu.miu.dto;


import edu.miu.selfassessmentservice.domain.Student;

public class StudentAdapter {


    public static Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        if(student != null){
            student.setId(studentDto.getId());
            student.setStudentNumber(studentDto.getStudentNumber());
            student.setStudentName(studentDto.getStudentName());
        }
        return student;
    }
}
