package dev.patika.homework02.controller;

import dev.patika.homework02.entity.Course;
import dev.patika.homework02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("course/{id}")
    public Course getCourse(@PathVariable int id){
        Course course = courseService.findById(id);
        return course;
    }

    @GetMapping("course/delete/{id}")
    public HttpStatus deleteCourse(@PathVariable int id){
        courseService.deleteById(id);
        return HttpStatus.OK;
    }

    @PostMapping("course/update/{id}")
    public Course updateCourse(@PathVariable int id,@RequestBody Course course){
        Course willUpdateCourse = courseService.findById(id);
        System.out.println(course.getCourseCode());
        willUpdateCourse.setName(course.getName());
        willUpdateCourse.setCourseCode(course.getCourseCode());
        willUpdateCourse.setCredit(course.getCredit());
        courseService.save(willUpdateCourse);
        return willUpdateCourse;
    }

}
