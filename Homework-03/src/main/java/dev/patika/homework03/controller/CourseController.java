package dev.patika.homework03.controller;

import dev.patika.homework03.entity.Course;
import dev.patika.homework03.entity.Instructor;
import dev.patika.homework03.entity.Student;
import dev.patika.homework03.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("courses")
    public ResponseEntity<Course> getAllCourse(){
        return new ResponseEntity(courseService.findAll(),HttpStatus.OK);
    }


    @GetMapping("course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){
        Course course = courseService.findById(id);
        return new ResponseEntity(course,HttpStatus.OK);
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
    public ResponseEntity updateCourse(@RequestBody Course course){
        courseService.update(course);
        return new ResponseEntity("Course Updated",HttpStatus.OK);
    }

    @PostMapping("course/new")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        courseService.save(course);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("course/search/{word}")
    public ResponseEntity<Course> searchCourse(@PathVariable String word){
        return new ResponseEntity(courseService.search(word),HttpStatus.OK);
    }

}
