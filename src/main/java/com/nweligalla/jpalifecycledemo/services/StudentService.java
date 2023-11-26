package com.nweligalla.jpalifecycledemo.services;

import java.util.List;

import com.nweligalla.jpalifecycledemo.entities.Student;

public interface StudentService {

    Student save(Student student);    
    
    Student getByID(long studentID);    
    
    List<Student> getAll();


}
