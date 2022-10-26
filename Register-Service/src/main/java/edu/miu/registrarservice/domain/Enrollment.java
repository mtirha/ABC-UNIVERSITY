package edu.miu.registrarservice.domain;

import edu.miu.registrarservice.enums.EnrollmentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String enrollNumber;
    private EnrollmentStatus status = EnrollmentStatus.ACCEPT;
    private String grade;

    @ManyToOne
    private CourseOffering courseOffering;

    @OneToOne
    private Student student;

}
