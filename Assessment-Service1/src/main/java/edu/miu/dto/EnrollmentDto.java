package edu.miu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentDto {

    private long id;
    private String enrollNumber;
    private StudentDto studentDto;
    private CourseOfferingDto courseOfferingDto;

}
