package dev.patika.homework02.controller;

import dev.patika.homework02.entity.Course;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id, Model model){
        Student student = studentService.findById(id);
        return student;
    }

    @PostMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id, Student student){
        Student foundStudent = studentService.findById(id);
        foundStudent.setName(student.getName());
        foundStudent.setAddress(student.getAddress());
        foundStudent.setGender(student.getGender());
        studentService.save(foundStudent);
        return foundStudent;
    }

    @DeleteMapping("/student/delete/{id}")
    public HttpStatus deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return HttpStatus.OK;
    }

}
