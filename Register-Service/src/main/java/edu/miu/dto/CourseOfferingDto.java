package edu.miu.dto;


import edu.miu.registrarservice.domain.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseOfferingDto {

    private long id;
    private String offerNumber;
    private CourseDto courseDto;
    private FacultyDto facultyDto;

}
