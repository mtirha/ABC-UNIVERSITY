package edu.miu.assessmentservice.domain.entity;


import edu.miu.assessmentservice.domain.enums.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String enrollNumber;
    private EnrollmentStatus status; // get in this microservices only the PAID enrollments
    @Column(columnDefinition = "double default 0")
    private double grade;

    @OneToOne(cascade={CascadeType.MERGE})
    private Student student;

    @ManyToOne
    @JoinColumn(name="courseOffering_id")
    private CourseOffering courseOffering;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="enrollment_id")
    private List<Assessment> assessments;

    public void computeGrade() {
        double result = 0;
        for(Assessment assessment : this.assessments){
            result += assessment.getPercentage() * assessment.computeScore();
        }
        this.grade = result ;
    }

}
