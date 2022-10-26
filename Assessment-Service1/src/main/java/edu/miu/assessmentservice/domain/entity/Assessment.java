package edu.miu.assessmentservice.domain.entity;


import edu.miu.assessmentservice.domain.enums.AssessmentType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String assessNumber;
    private String title;
    private AssessmentType assessmentType;
    private double percentage;
    private LocalDateTime creationDate;
    private LocalDateTime openDate;
    private LocalDateTime dueDate;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "assessment_id")
    private List<Question> questions;

    @ManyToOne
    private Enrollment enrollment;

    public Assessment(String title, AssessmentType assessmentType, double percentage, int delayDueDate) {
        this.title = title;
        this.assessmentType = assessmentType;
        this.percentage = percentage;
        this.creationDate = LocalDateTime.now();
        this.openDate = LocalDateTime.now();
        this.dueDate = LocalDateTime.now().plusDays(delayDueDate);
        this.questions = new ArrayList<>();
    }

    public double computeScore() {
        double result = 0;
        double questionScore = 0;
        double studentScore = 0;
        for (Question q : this.questions) {
            questionScore += q.getTotalScore();
            studentScore += q.getStudentScore();
        }
        return studentScore / questionScore;
    }

    public static String GenerateNumber(String lastNumber){
        String result = null;
        if(lastNumber == null){
            result = "ASS" + LocalDate.now().getYear() + "00001" ;
        }else{
            String num = lastNumber.substring(8);
            int val = Integer.valueOf(num);
            val += 1;
            result = "ASS" + LocalDate.now().getYear() + String.valueOf(val).format("%05d", val) ;
        }
        System.out.println(result);
        return result;
    }
}
