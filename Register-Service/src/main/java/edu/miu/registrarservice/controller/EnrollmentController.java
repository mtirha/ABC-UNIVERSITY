package edu.miu.registrarservice.controller;


import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.domain.Enrollment;
import edu.miu.registrarservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/{offerNumber}/{studentNumber}")
    public ResponseEntity<?> add(@PathVariable String offerNumber, @PathVariable String studentNumber, @RequestBody Enrollment enrollment) {
        enrollmentService.create(offerNumber, studentNumber, enrollment);
        return new ResponseEntity<Enrollment>(enrollment, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable String enrollNumber, @RequestBody Enrollment enrollment) throws Exception {
        Enrollment updated = enrollmentService.update(enrollNumber, enrollment);
        if(updated == null)
            throw new Exception("Enrollment with enroll number " + enrollNumber + " is not found");
        else
            return new ResponseEntity<Enrollment>(enrollment, HttpStatus.OK);
    }

    @GetMapping("/{studentNumber}")
    public ResponseEntity<?>  getAll(String studentNumber){
        List<Enrollment> enrollments = enrollmentService.getAllByStudent(studentNumber);
        return new ResponseEntity<List<Enrollment>>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) throws Exception {
        Enrollment enrollment = enrollmentService.getOne(id).orElse(null);
        if (enrollment == null)
            throw new Exception("User with id " + id + " is not found");
        return new ResponseEntity<Enrollment>(enrollment, HttpStatus.OK);
    }

    @GetMapping("/{enrollNumber}")
    public ResponseEntity<?> getByEnrollNumberr(@PathVariable String enrollNumber) throws Exception {
        Enrollment enrollment = enrollmentService.getByEnrollNumberr(enrollNumber);
        if (enrollment == null)
            throw new Exception("Enrollment with enroll number " + enrollNumber + " is not found");
        return new ResponseEntity<Enrollment>(enrollment, HttpStatus.OK);
    }
}
