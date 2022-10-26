package edu.miu.registrarservice.controller;

import edu.miu.registrarservice.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.miu.registrarservice.service.CourseService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/registration/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Course course) {
        courseService.add(course);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @PutMapping("/{courseNumber}")
    public ResponseEntity<?> update(@PathVariable String courseNumber, @RequestBody Course course) throws Exception {
        Course updated = courseService.update(courseNumber, course);
        if(updated == null)
            throw new Exception("Course with course number " + courseNumber + " is not found");
        else
            return new ResponseEntity<Course>(updated, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?>  getAll(){
        List<Course> courses = courseService.getAll();
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) throws Exception {
        Course course = courseService.getOne(id).orElse(null);
        if (course == null)
            throw new Exception("Course with id " + id + " is not found");
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
    @GetMapping("/{courseNumber}")
    public ResponseEntity<?> getByCourseNumber(@PathVariable String courseNumber) throws Exception {
        Course course = courseService.getByCourseNumber(courseNumber);
        if (course == null)
            throw new Exception("Course with course number " + courseNumber + " is not found");
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

}
