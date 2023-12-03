package com.nweligalla.jpalifecycledemo.services;

import java.util.List;

import com.nweligalla.jpalifecycledemo.dtos.StudentDTO;

public interface StudentService {

    StudentDTO save(StudentDTO student);    
    
    StudentDTO getByID(long studentID);
    
    boolean deleteByID(long studentID );
    
    List<StudentDTO> getAll();


}
