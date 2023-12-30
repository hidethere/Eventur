package com.eventur.server.controller;

import com.eventur.server.exception.ResponseHandler;
import com.eventur.server.model.User;
import com.eventur.server.service.UserService;

import io.micrometer.common.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;
    private JdbcTemplate jdbcTemplate;

//---------------USER--------------------------------------
    // POST
    @PostMapping
    public ResponseEntity<Object> Register(@RequestBody User user) {
        
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getEmail()) || (StringUtils.isEmpty(user.getClerkId()) && StringUtils.isEmpty(user.getPassword())) || StringUtils.isEmpty(user.getfirstName()) || StringUtils.isEmpty(user.getfirstName()) || StringUtils.isEmpty(user.getPhoto())) {

        return ResponseHandler.generateResponse("Fill all the fields", HttpStatus.BAD_REQUEST, user);

    }

        return service.Register(user);
    }
    
    // GET
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    
    @GetMapping(path="/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id).orElse(null);
    }

    // PUT
    @PutMapping(path="/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable String id, @RequestBody User updatedUser) {

        return service.updateUser(id, updatedUser);
    }
 
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }


}
    

