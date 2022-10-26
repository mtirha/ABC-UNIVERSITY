package edu.miu.assessmentservice.domain.entity;


import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Setter
@Entity
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String offerNumber;

    @ManyToOne(cascade={CascadeType.MERGE})
    private Course course;

    @OneToOne(cascade={CascadeType.MERGE})
    private Faculty faculty;

    @OneToMany(mappedBy="courseOffering")
    private List<Enrollment> enrollments;



}
