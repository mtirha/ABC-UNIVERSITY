package edu.miu.selfassessmentservice.controller;

import edu.miu.selfassessmentservice.domain.SelfAssessment;
import edu.miu.selfassessmentservice.service.ISelfAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/selfassessments")
public class SelfAssessmentController {

    private final ISelfAssessmentService assessmentService;

    @GetMapping("/{assessmentId}")
    public SelfAssessment getAssessmentById(@PathVariable("assessmentId") long id) {
        return assessmentService.getAssessmentById(id);
    }

    @GetMapping("/students/{cat}/{subcat}")
    public SelfAssessment generateAssessment(@PathVariable String cat, @PathVariable String subcat) {
        return assessmentService.generateAssessment(cat, subcat);
    }


}
