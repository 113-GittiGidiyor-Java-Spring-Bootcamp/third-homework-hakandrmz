package dev.patika.homework02.controller;

import dev.patika.homework02.entity.Instructor;
import dev.patika.homework02.entity.InstructorType;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.InstructorService;
import dev.patika.homework02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping("/instructor/update/{id}")
    public HttpStatus updateInstructor(@PathVariable int id,@RequestBody Instructor instructor){
        Instructor foundInstructor = instructorService.findById(id);
        foundInstructor.setName(instructor.getName());
        foundInstructor.setAddress(instructor.getAddress());
        foundInstructor.setPhoneNumber(instructor.getPhoneNumber());
        foundInstructor.setSalary(instructor.getSalary());
        foundInstructor.setType(instructor.getType());
        instructorService.save(foundInstructor);
        return HttpStatus.OK;
    }

    @GetMapping("/instructor/delete/{id}")
    public String deleteInstructor(@PathVariable int id){
        instructorService.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/instructor/findFirst3BySalary")
    public List<Instructor> getFindFirst3BySalary(){
        double i=0;
        return instructorService.findFirst3BySalary(i);
    }

}
