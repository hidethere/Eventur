package com.eventur.server.controller;

import com.eventur.server.model.User;
import com.eventur.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id).orElse(null);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        return service.saveUser(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/test-database-connection")
    public String testDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Database connection is okay!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
}
