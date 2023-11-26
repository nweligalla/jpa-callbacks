package com.nweligalla.jpalifecycledemo.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nweligalla.jpalifecycledemo.entities.Student;
import com.nweligalla.jpalifecycledemo.repos.StudentRepo;
import com.nweligalla.jpalifecycledemo.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getByID(long studentID) {
        return studentRepo.findById(studentID).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

}
