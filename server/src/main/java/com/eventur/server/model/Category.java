package com.eventur.server.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "`category`")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;
    
    @OneToMany(mappedBy = "category")
    private List<Event> events;

    // Getters and setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
   
}
