package edu.miu.adminservice.controller;

import edu.miu.adminservice.entity.Registrar;
import edu.miu.adminservice.exception.AdminException;
import edu.miu.adminservice.service.RegistrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/admin/registrars")
@RestController
public class RegistrarController {

//    @Autowired
//    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    RegistrarService userService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Registrar user) {
        userService.add(user);
        return new ResponseEntity<Registrar>(user, HttpStatus.OK);
    }

    @PutMapping("/{userNumber}")
    public ResponseEntity<?> update(@PathVariable String userNumber, @RequestBody Registrar user) {
        userService.update(userNumber, user);
        return new ResponseEntity<Registrar>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Registrar> users = userService.getAll();
        return new ResponseEntity<List<Registrar>>(users, HttpStatus.OK);
    }

    @GetMapping("/{userNumber}")
    public ResponseEntity<?> getByUserNumber(@PathVariable String userNumber) {
        Registrar user = userService.getByUserNumber(userNumber);
        if (user == null)
            throw new AdminException("User with user id " + userNumber + " are not found");
        return new ResponseEntity<Registrar>(user, HttpStatus.OK);
    }



}



