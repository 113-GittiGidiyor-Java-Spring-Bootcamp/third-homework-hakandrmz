package dev.patika.homework02.controller;

import dev.patika.homework02.entity.Instructor;
import dev.patika.homework02.entity.InstructorType;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.InstructorService;
import dev.patika.homework02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/instructor/edit/{id}")
    public String editInstructor(@PathVariable int id, Model model){
        Instructor instructor = instructorService.findById(id);
        List<String> enumTypes = Stream.of(InstructorType.values()).map(InstructorType::name).collect(Collectors.toList());
        model.addAttribute("instructor",instructor);
        model.addAttribute("enumTypes",enumTypes);
        System.out.println(enumTypes);
        return "instructors/edit";
    }

    @PostMapping("/instructor/update/{id}")
    public String updateInstructor(@PathVariable int id, Instructor instructor){
        Instructor foundInstructor = instructorService.findById(id);
        foundInstructor.setName(instructor.getName());
        foundInstructor.setAddress(instructor.getAddress());
        foundInstructor.setPhoneNumber(instructor.getPhoneNumber());
        foundInstructor.setSalary(instructor.getSalary());
        foundInstructor.setType(instructor.getType());
        instructorService.save(foundInstructor);
        return "redirect:/index";
    }

    @GetMapping("/instructor/delete/{id}")
    public String deleteInstructor(@PathVariable int id){
        instructorService.deleteById(id);
        return "redirect:/index";
    }

}
