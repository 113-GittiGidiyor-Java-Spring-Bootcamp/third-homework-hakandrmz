package dev.patika.homework02.controller;

import dev.patika.homework02.service.CourseService;
import dev.patika.homework02.service.InstructorService;
import dev.patika.homework02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final CourseService courseService;

    @GetMapping({"","/","/index"})
    public String getMainPage(Model model) {
        model.addAttribute("courses",courseService.findAll());
        return "index";
    }

}
