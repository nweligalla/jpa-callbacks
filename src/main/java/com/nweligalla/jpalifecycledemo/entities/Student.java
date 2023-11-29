package com.nweligalla.jpalifecycledemo.entities;

import java.time.LocalDateTime;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    private LocalDateTime accountCreatedTime;
    private LocalDateTime accountLastUpdatedTime;

    private String fullId;
    

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getAccountCreatedTime() {
        return accountCreatedTime;
    }

    public LocalDateTime getAccountLastUpdatedTime() {
        return accountLastUpdatedTime;
    }

    public void setAccountCreatedTime(LocalDateTime accountCreatedTime) {
        this.accountCreatedTime = accountCreatedTime;
    }

    public void setAccountLastUpdatedTime(LocalDateTime accountLastUpdatedTime) {
        this.accountLastUpdatedTime = accountLastUpdatedTime;
    }

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    @PrePersist
    private void beforePersist() {

        System.out.println("I\'m New");
        LocalDateTime dateTime = LocalDateTime.now();
        setAccountCreatedTime(dateTime);
        setAccountLastUpdatedTime(dateTime);
    }

    @PreUpdate
    private void beforeUpdate() {
        System.out.println("I\'m Updating");
        setAccountLastUpdatedTime(LocalDateTime.now());
        createFullID();
    }

    @PostPersist
    private void createFullID() {
        String fullID = "STU_" + this.firstName.charAt(0) + this.lastName.charAt(0) + "_"
                + getRandomString(3) + this.id
                + getRandomString(4);

        System.out.println(this.firstName.charAt(0));
        setFullId(fullID);
    }





    

    private String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder randomString = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }

        return randomString.toString();
    }
}
