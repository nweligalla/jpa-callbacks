package com.nweligalla.jpalifecycledemo.dtos;

import java.time.LocalDateTime;

public class StudentDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime accountCreatedTime;
    private LocalDateTime accountLastUpdatedTime;



    public StudentDTO() {
    }



    public StudentDTO(long id, String firstName, String lastName, String email, LocalDateTime accountCreatedTime,
            LocalDateTime accountLastUpdatedTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accountCreatedTime = accountCreatedTime;
        this.accountLastUpdatedTime = accountLastUpdatedTime;
    }



    public long getId() {
        return id;
    }



    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public String getEmail() {
        return email;
    }



    public LocalDateTime getAccountCreatedTime() {
        return accountCreatedTime;
    }



    public LocalDateTime getAccountLastUpdatedTime() {
        return accountLastUpdatedTime;
    }

    

    
    

   
   

    


}
