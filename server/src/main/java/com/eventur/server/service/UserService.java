package com.eventur.server.service;

import com.eventur.server.exception.ResponseHandler;
import com.eventur.server.model.User;
import com.eventur.server.repository.UserRepository;

import io.micrometer.common.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//------------REGISTER-----------------------------------
    public ResponseEntity<Object> Register(User User) {
        
        if(userRepository.existsByEmail(User.getEmail()) || userRepository.existsByUsername(User.getUsername())) {
		return ResponseHandler.generateResponse("email/username already exists", HttpStatus.BAD_REQUEST, User);
        }
    
        User newUser = new User();
        // Hash the password before saving it
        if(StringUtils.isEmpty(User.getClerkId())) {
            newUser.setPassword(passwordEncoder.encode(User.getPassword()));
        }
        
        System.out.print(newUser);
        
        // save User
        userRepository.save(User);
        
        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, User);
    }
 

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<Object> updateUser(String id, User User) {
        User user = userRepository.findByClerkId(id);

        if(user != null){
            // Update relevant fields of the existing user with the data from updatedUser
            if (User.getUsername() != null) {
                user.setUsername(User.getUsername());
            }

            if (User.getEmail() != null) {
                user.setEmail(User.getEmail());
            }

              if (User.getPassword() != null) {
                user.setPassword(User.getPassword());
            }

              if (User.getPhoto() != null) {
                user.setPhoto(User.getPhoto());
            }

              if (User.getUpdatedAt() != null) {
                user.setUpdatedAt(User.getUpdatedAt());
            }

            // Update other fields as needed
            userRepository.save(user);
        }

        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, User);
    }

    public Optional <User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
