package dev.patika.homework03.controller;

import dev.patika.homework03.entity.Course;
import dev.patika.homework03.entity.Student;
import dev.patika.homework03.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<Course> getAllCourse(){
        return new ResponseEntity(studentService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id, Model model){
        Student student = studentService.findById(id);
        return student;
    }

    @PostMapping("/student/update/{id}")
    public Student updateStudent(Student student){
        Student foundStudent = studentService.findById(student.getId());
        foundStudent.setName(student.getName());
        foundStudent.setAddress(student.getAddress());
        foundStudent.setGender(student.getGender());
        studentService.save(foundStudent);
        return foundStudent;
    }

    @GetMapping("/student/delete/{id}")
    public HttpStatus deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/getGendersWithGrouping")
    public List<?> getAgesWithGrouping(){
        return studentService.getGendersWithGrouping();
    }


    @GetMapping("/deleteStudentByName/{name}")
    public String deleteStudentByName(@PathVariable String name){
        studentService.deleteByName(name);
        return name + " içeren isimler silindi";
    }

}
