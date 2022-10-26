package edu.miu.dto;

import edu.miu.adminservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultyDto implements Serializable {

    private long id;
    private String facultyNumber;
    private String facultyName;
	
}
