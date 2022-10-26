package edu.miu.registrarservice.controller;

import edu.miu.registrarservice.domain.Course;
import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration/offers")
public class CourseOfferingController {

    @Autowired
    private CourseOfferingService courseOfferingService;

    @PostMapping("/{courseNumber}/{facultyNumber}")
    public ResponseEntity<?> add(@PathVariable String courseNumber, @PathVariable String facultyNumber, @RequestBody CourseOffering courseOffering) {
        courseOfferingService.create(courseNumber, facultyNumber, courseOffering);
        return new ResponseEntity<CourseOffering>(courseOffering, HttpStatus.OK);
    }

    @PutMapping("/{offerNumber}")
    public ResponseEntity<?> update(@PathVariable String offerNumber, @RequestBody CourseOffering courseOffering) throws Exception {
        CourseOffering updated = courseOfferingService.update(offerNumber, courseOffering);
        if(updated == null)
            throw new Exception("Course with offering number " + offerNumber + " is not found");
        else
            return new ResponseEntity<CourseOffering>(courseOffering, HttpStatus.OK);
    }

    @GetMapping("/{facultyNumber}")
    public ResponseEntity<?>  getAllByFaculty(@PathVariable String facultyNumber) throws Exception {
        List<CourseOffering> courseOfferings = courseOfferingService.getAllByFaculty(facultyNumber);
        if(courseOfferings.size() == 0)
            throw new Exception("Courses of faculty number " + facultyNumber + " are not found");
        else
            return new ResponseEntity<List<CourseOffering>>(courseOfferings, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable long id) throws Exception {
//        CourseOffering courseOffering = courseOfferingService.getOne(id).orElse(null);
//        if (courseOffering == null)
//            throw new Exception("Course offering with id " + id + " is not found");
//        return new ResponseEntity<CourseOffering>(courseOffering, HttpStatus.OK);
//    }

//    @GetMapping("/{offerNumber}")
//    public ResponseEntity<?> getByCourseNumber(@PathVariable String offerNumber) throws Exception {
//        CourseOffering courseOffering = courseOfferingService.getByOfferNumber(offerNumber);
//        if (courseOffering == null)
//            throw new Exception("Course with offering number " + offerNumber + " is not found");
//        return new ResponseEntity<CourseOffering>(courseOffering, HttpStatus.OK);
//    }


}
