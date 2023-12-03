package com.nweligalla.jpalifecycledemo.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

@Entity
public class Student {

    private static Log log = LogFactory.getLog(Student.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    private LocalDate birthDate;

    @Transient
    private int age;

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

    public Student(Long id, String firstName, String lastName, String email, String dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PrePersist
    private void beforePersist() {

        // System.out.println("I\'m New");
        LocalDateTime dateTime = LocalDateTime.now();
        setAccountCreatedTime(dateTime);
        setAccountLastUpdatedTime(dateTime);
    }

    @PreUpdate
    private void beforeUpdate() {
        // System.out.println("I\'m Updating");
        setAccountLastUpdatedTime(LocalDateTime.now());
        createFullID();
    }

    @PostPersist
    private void createFullID() {
        String fullID = "STU_" + this.firstName.charAt(0) + this.lastName.charAt(0) + "_"
                + getRandomString(3) + this.id
                + getRandomString(4);

        // System.out.println(this.firstName.charAt(0));
        setFullId(fullID);
        afterLoad();
    }

    @PostUpdate
    private void afterUpdate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        log.info("Applied changes to Student:" + this.id + " at " + dateFormat.format(new Date()));
    }

    @PreRemove
    private void beforeRemove() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        log.warn("Romoving Student: " + this.id + " at " + dateFormat.format(new Date()));
    }

    @PostRemove
    private void afterRemove() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        log.info("Romoved Student: " + this.id + " at " + dateFormat.format(new Date()));
    }

    @PostLoad
    private void afterLoad() {
        // System.out.println("Running post Load");
        Period period = Period.between(this.birthDate, LocalDate.now());
        setAge(period.getYears());
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
