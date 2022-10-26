package edu.miu.adminservice.controller;

import edu.miu.dto.StudentAdapter;
import edu.miu.dto.StudentDto;
import edu.miu.adminservice.entity.Student;
import edu.miu.adminservice.exception.AdminException;
import edu.miu.adminservice.integration.StudentSender;
import edu.miu.adminservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/students")
public class StudentController {

    @Autowired
    StudentService userService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Student user) {
        userService.add(user);
        return new ResponseEntity<Student>(user, HttpStatus.OK);
    }

    @PutMapping("/{userNumber}")
    public ResponseEntity<?> update(@PathVariable String userNumber, @RequestBody Student user) {
        userService.update(userNumber, user);
        return new ResponseEntity<Student>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Student> users = userService.getAll();
        return new ResponseEntity<List<Student>>(users, HttpStatus.OK);
    }

    @GetMapping("/{userNumber}")
    public ResponseEntity<?> getByUserNumber(@PathVariable String userNumber) {
        Student user = userService.getByUserNumber(userNumber);
        if (user == null)
            throw new AdminException("User with user id " + userNumber + " are not found");
        return new ResponseEntity<Student>(user, HttpStatus.OK);
    }



}



