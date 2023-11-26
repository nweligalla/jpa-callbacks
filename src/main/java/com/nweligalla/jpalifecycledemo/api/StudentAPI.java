package com.nweligalla.jpalifecycledemo.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nweligalla.jpalifecycledemo.entities.Student;
import com.nweligalla.jpalifecycledemo.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentAPI {

    private final StudentService studentService;

    public StudentAPI(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get-all")
    public List<Student> getAllStudents() {

        System.out.println("Getting all Students");

        return studentService.getAll();
    }

    @GetMapping("/get/{id}")
    public Student getAllStudents(@PathVariable("id") long studentID) {
        return studentService.getByID(studentID);
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

}
