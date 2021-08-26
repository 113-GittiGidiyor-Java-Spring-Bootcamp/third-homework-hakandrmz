package dev.patika.homework02.controller;

import dev.patika.homework02.entity.Course;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "students/edit";
    }

    @PostMapping("/student/update/{id}")
    public String updateStudent(@PathVariable int id, Student student){
        Student foundStudent = studentService.findById(id);
        foundStudent.setName(student.getName());
        foundStudent.setAddress(student.getAddress());
        foundStudent.setGender(student.getGender());
        studentService.save(foundStudent);
        return "redirect:/index";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return "redirect:/index";
    }

}
