package dev.patika.homework02.controller;

import dev.patika.homework02.entity.Course;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.CourseService;
import dev.patika.homework02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping("course/edit/{id}")
    public String getCourse(@PathVariable int id, Model model){
        Course course = courseService.findById(id);
        List<Student> students = course.getStudents();
        model.addAttribute("course",course);
        model.addAttribute("students",students);
        return "courses/edit";
    }

    @GetMapping("course/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteById(id);
        return "redirect:/index";
    }

    @PostMapping("course/update/{id}")
    public String updateCourse(@PathVariable int id,Course course){
        Course willUpdateCourse = courseService.findById(course.getId());
        willUpdateCourse.setName(course.getName());
        willUpdateCourse.setCourseCode(course.getCourseCode());
        courseService.save(willUpdateCourse);
        return "redirect:/index";
    }

}
