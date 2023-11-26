package com.nweligalla.jpalifecycledemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nweligalla.jpalifecycledemo.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
