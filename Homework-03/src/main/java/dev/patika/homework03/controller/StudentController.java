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

    @GetMapping("/student/delete/{id}")
    public HttpStatus deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("student/delete")
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
        studentService.deleteById(student.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getGendersWithGrouping")
    public List<?> getAgesWithGrouping(){
        return studentService.getGendersWithGrouping();
    }


    @PutMapping("/student/update")
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentService.update(student);
        return new ResponseEntity("Student Updated", HttpStatus.OK);
    }

    @GetMapping("/deleteStudentByName/{name}")
    public String deleteStudentByName(@PathVariable String name){
        studentService.deleteByName(name);
        return name + " deleted";
    }

    @PostMapping("student/new")
    public ResponseEntity<Course> addCourse(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity("Student Saved",HttpStatus.OK);
    }

    @GetMapping("student/search/{word}")
    public ResponseEntity<Student> searchStudent(@PathVariable String word){
        return new ResponseEntity(studentService.search(word),HttpStatus.OK);
    }

}
