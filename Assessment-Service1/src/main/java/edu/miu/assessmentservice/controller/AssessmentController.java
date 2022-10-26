package edu.miu.assessmentservice.controller;


import edu.miu.assessmentservice.dto.AssessmentDto;
import edu.miu.assessmentservice.dto.AssessmentDtos;
import edu.miu.assessmentservice.dto.QuestionDto;
import edu.miu.assessmentservice.exception.AssessmentNotFoundException;
import edu.miu.assessmentservice.service.IAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/assessments")
public class AssessmentController {

//    @Autowired
//    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private IAssessmentService assessmentService ;

//    @PutMapping("/{assessNumber}")
//    public ResponseEntity<?> update(@PathVariable String assessNumber, @RequestBody @Valid AssessmentDto assessmentDto){
//        assessmentService.update(assessmentDto);
//        return new ResponseEntity<AssessmentDto>(assessmentDto, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{assessNumber}")
//    public ResponseEntity<?> delete(@PathVariable String assessNumber) throws AssessmentNotFoundException {
//        List<AssessmentDto> assessmentDtos = assessmentService.findByAssessNumber(assessNumber);
//        if (assessmentDtos.size() == 0) {
//            throw new AssessmentNotFoundException("Assessment with assessment number " + assessNumber + " is not available");
//        }
//        assessmentService.delete(assessNumber);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/{assessNumber}")
    public ResponseEntity<?> findByAssessNumber(@PathVariable String assessNumber) throws AssessmentNotFoundException {
        List<AssessmentDto> assessmentDtos =  assessmentService.findByAssessNumber(assessNumber);
        if (assessmentDtos.size() == 0) {
            throw new AssessmentNotFoundException("Assessment with assessment number " + assessNumber + " is not available");
        }
        return new ResponseEntity<AssessmentDto>(assessmentDtos.get(0), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        AssessmentDtos assessments = new AssessmentDtos(assessmentService.findAll());
        return new ResponseEntity<AssessmentDtos>(assessments, HttpStatus.OK);
    }

    @PostMapping("/{offerNumber}/{title}/{assessmentType}/{percentage}")
    public ResponseEntity<?> create(@PathVariable String offerNumber,
                                    @PathVariable String title,
                                    @PathVariable String assessmentType,
                                    @PathVariable double percentage,
                                    @RequestBody List<@Valid QuestionDto> questions){
        AssessmentDto assessmentDto = assessmentService.create(offerNumber, title, assessmentType, percentage, questions);
        return new ResponseEntity<AssessmentDto> (assessmentDto, HttpStatus.OK);
    }


    @PutMapping("/{enrollNumber}/{assessNumber}/{questNumber}")
    public ResponseEntity<?> take(@PathVariable String enrollNumber,
                                  @PathVariable String assessNumber,
                                  @PathVariable String questNumber,
                                  @RequestBody List<String> studentAnswers){
        assessmentService.takeAssessment(enrollNumber, assessNumber, questNumber,  studentAnswers);
        return new ResponseEntity<List<String>>(studentAnswers, HttpStatus.OK);
    }


}

























