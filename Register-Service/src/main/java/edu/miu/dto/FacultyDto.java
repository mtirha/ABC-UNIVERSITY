package edu.miu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultyDto implements Serializable {

    private long id;
    private String facultyNumber;
    private String facultyName;
	
}
