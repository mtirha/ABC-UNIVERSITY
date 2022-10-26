package edu.miu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto implements Serializable {

    private long id;
    private String studentNumber;
    private String studentName;

}
