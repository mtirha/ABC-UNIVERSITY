package edu.miu.adminservice.controller;

import edu.miu.adminservice.service.IUserService;
import edu.miu.dto.FacultyAdapter;
import edu.miu.dto.FacultyDto;
import edu.miu.dto.StudentAdapter;
import edu.miu.dto.StudentDto;
import edu.miu.adminservice.entity.Faculty;
import edu.miu.adminservice.exception.AdminException;
import edu.miu.adminservice.integration.FacultySender;
import edu.miu.adminservice.integration.StudentSender;
import edu.miu.adminservice.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/admin/faculties")
@RestController
public class FacultyController {

//    @Autowired
//    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    FacultyService userService;

	@PostMapping
    public ResponseEntity<?> add(@RequestBody Faculty user) {
        userService.add(user);
        return new ResponseEntity<Faculty>(user, HttpStatus.OK);
    }

    @PutMapping("/{userNumber}")
    public ResponseEntity<?> update(@PathVariable String userNumber, @RequestBody Faculty user) {
        userService.update(userNumber, user);
        return new ResponseEntity<Faculty>(user, HttpStatus.OK);
    }

    @GetMapping
	public ResponseEntity<?> getAll(){
		List<Faculty> users = userService.getAll();
        return new ResponseEntity<List<Faculty>>(users, HttpStatus.OK);
	}

    @GetMapping("/{userNumber}")
    public ResponseEntity<?> getByUserNumber(@PathVariable String userNumber) {
        Faculty user = userService.getByUserNumber(userNumber);
        if (user == null)
            throw new AdminException("User with user id " + userNumber + " are not found");
        return new ResponseEntity<Faculty>(user, HttpStatus.OK);
    }



}



