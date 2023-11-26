package com.nweligalla.jpalifecycledemo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @PrePersist
    private void beforePersist() {

        System.out.println("Im NEW");
        LocalDateTime dateTime = LocalDateTime.now();

        setAccountCreatedTime(dateTime);

        setAccountLastUpdatedTime(dateTime);
    }

    @PreUpdate
    private void beforeUpdate() {
        System.out.println("Im Updating");
        setAccountLastUpdatedTime(LocalDateTime.now());
    }

}
