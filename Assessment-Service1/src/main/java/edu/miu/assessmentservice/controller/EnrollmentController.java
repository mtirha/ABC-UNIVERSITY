package edu.miu.assessmentservice.controller;


import edu.miu.assessmentservice.domain.entity.CourseOffering;
import edu.miu.assessmentservice.exception.CourseOfferingNotFoundException;
import edu.miu.assessmentservice.service.ICourseOfferingService;
import edu.miu.assessmentservice.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/grades")
public class EnrollmentController {

//    @Autowired
//    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private IEnrollmentService enrollmentService ;

    @Autowired
    private ICourseOfferingService courseOfferingService ;

    @PutMapping("/{offerNumber}")
    public ResponseEntity<?> update(@PathVariable String offerNumber) throws CourseOfferingNotFoundException {
        CourseOffering courseOffering = courseOfferingService.findByOfferNumber(offerNumber);
        if(courseOffering == null)
            throw new CourseOfferingNotFoundException("Course offering with number " + offerNumber + " is not available");
        enrollmentService.updateGrades(offerNumber);
        return new ResponseEntity<String>("All grades are computed and updated for this course offering number " + offerNumber, HttpStatus.OK);
    }

    @GetMapping("/{offerNumber}")
    public ResponseEntity<?> getAllGrades(@PathVariable String offerNumber) throws CourseOfferingNotFoundException {
        CourseOffering courseOffering = courseOfferingService.findByOfferNumber(offerNumber);
        if(courseOffering == null)
            throw new CourseOfferingNotFoundException("Course offering with number " + offerNumber + " is not available");
        Map<String, String> map = enrollmentService.getAllGrades(offerNumber);
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
    }



}

























