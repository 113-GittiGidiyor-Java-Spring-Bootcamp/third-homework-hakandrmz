package dev.patika.homework03.controller;

import dev.patika.homework03.entity.Course;
import dev.patika.homework03.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){
        Course course = courseService.findById(id);
        return new ResponseEntity(course,HttpStatus.OK);
    }

    @GetMapping("courses")
    public ResponseEntity<Course> getAllCourse(){
        return new ResponseEntity(courseService.findAll(),HttpStatus.OK);
    }

    @GetMapping("course/delete/{id}")
    public HttpStatus deleteCourse(@PathVariable int id){
        courseService.deleteById(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("course/delete")
    public ResponseEntity<Course> deleteCourse(@RequestBody Course course) {
        courseService.deleteById(course.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("course/update")
    public Course updateCourse(@RequestBody Course course){
        Course willUpdateCourse = courseService.findById(course.getId());
        willUpdateCourse.setName(course.getName());
        willUpdateCourse.setCourseCode(course.getCourseCode());
        willUpdateCourse.setCredit(course.getCredit());
        courseService.save(willUpdateCourse);
        return willUpdateCourse;
    }

}
