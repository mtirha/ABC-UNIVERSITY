package edu.miu.registrarservice.domain;


import edu.miu.registrarservice.enums.Term;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String offerNumber;
    private LocalDate start;
    private LocalDate end;
    private Term term;
    String roomNumber;
    private int capacity;

    @ManyToOne
    private Course course;

    @OneToOne
    private Faculty faculty;

    public CourseOffering(LocalDate start, LocalDate end, Term term, String roomNumber, int capacity) {
        this.offerNumber = this.course.getCourseNumber() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear();
        this.start = start;
        this.end = end;
        this.term = term;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }
}
