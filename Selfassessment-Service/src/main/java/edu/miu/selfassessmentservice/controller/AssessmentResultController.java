package edu.miu.selfassessmentservice.controller;


import edu.miu.selfassessmentservice.domain.Answer;
import edu.miu.selfassessmentservice.domain.AssessmentResult;
import edu.miu.selfassessmentservice.service.IAssessmentResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/selfassessments/results")
public class AssessmentResultController {
    private IAssessmentResultService assessmentResultService;

    @PostMapping("/{studentNumber}")
    public void submitAssessment(@PathVariable("studentId") String studentNumber, @RequestBody List<Answer> studentAnswers) {

        //assessmentResultService.calculateScore();
        // Now save the student's assessment result
        assessmentResultService.save(studentNumber, studentAnswers);
    }

    @GetMapping("/{studentNumber}")
    public AssessmentResult getResults(@PathVariable("studentId") String studentNumber) {
        return assessmentResultService.getResultForStudent(studentNumber);
    }
}
