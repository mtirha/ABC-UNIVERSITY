package edu.miu.dto;

import edu.miu.adminservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto implements Serializable {

    private long id;
    private String studentNumber;
    private String studentName;

}
