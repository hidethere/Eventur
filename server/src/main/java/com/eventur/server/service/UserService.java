package com.eventur.server.service;

import com.eventur.server.model.User;
import com.eventur.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional <User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User saveUser(User User) {
        return repository.save(User);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

}
