package edu.miu.dto;

import edu.miu.adminservice.entity.Student;


public class StudentAdapter {


    public static StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        if(student != null){
            studentDto.setId(student.getId());
            studentDto.setStudentNumber(student.getUserNumber());
            studentDto.setStudentName(student.getFirstName() + ", " + student.getLastName());
        }
        return studentDto;
    }
}
