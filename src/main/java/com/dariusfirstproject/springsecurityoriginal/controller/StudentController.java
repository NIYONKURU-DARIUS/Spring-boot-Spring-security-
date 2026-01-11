package com.dariusfirstproject.springsecurityoriginal.controller;

import com.dariusfirstproject.springsecurityoriginal.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    List<Student> studentList = new ArrayList<>(List.of(
        new Student(1,"darius",90),
            new Student(2,"david", 78),
            new Student(3,"daniel", 65)));
    @GetMapping
    public List<Student> getStudents(){
        return studentList;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        studentList.add(student);
        return student;
    }
}
