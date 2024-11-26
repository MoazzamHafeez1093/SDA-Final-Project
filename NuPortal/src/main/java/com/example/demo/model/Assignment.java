package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String googleDriveLink;

    // Constructors
    public Assignment() {
    }

    public Assignment(String name, String googleDriveLink) {
        this.name = name;
        this.googleDriveLink = googleDriveLink;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoogleDriveLink() {
        return googleDriveLink;
    }

    public void setGoogleDriveLink(String googleDriveLink) {
        this.googleDriveLink = googleDriveLink;
    }
}
