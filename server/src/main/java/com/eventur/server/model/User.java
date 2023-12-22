package com.eventur.server.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    public User(){

    }

    public User(String username) {
        this.username = username;
    }

    public void setId(Long id2) {
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }




    // Getters and setters
}
