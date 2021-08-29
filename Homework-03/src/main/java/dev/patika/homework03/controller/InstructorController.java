package dev.patika.homework03.controller;

import dev.patika.homework03.entity.Course;
import dev.patika.homework03.entity.Instructor;
import dev.patika.homework03.entity.Student;
import dev.patika.homework03.service.InstructorService;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("instructors")
    public ResponseEntity<Course> getAllInstructor(){
        return new ResponseEntity(instructorService.findAll(),HttpStatus.OK);
    }

    @GetMapping("instructor/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable int id){
        Instructor instructor = instructorService.findById(id);
        return new ResponseEntity<>(instructor,HttpStatus.OK);
    }

    @GetMapping("/instructor/delete/{id}")
    public HttpStatus deleteInstructor(@PathVariable int id){
        instructorService.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("instructor/update")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor){
        instructorService.update(instructor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("instructor")
    public ResponseEntity<Instructor> deleteCourse(@RequestBody Instructor instructor) {
        instructorService.deleteById(instructor.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("instructor/new")
    public ResponseEntity addInstructor(@RequestBody Instructor instructor){
        instructorService.save(instructor);
        return new ResponseEntity("Instructor saved",HttpStatus.OK);
    }

    @GetMapping("instructor/search/{word}")
    public ResponseEntity<Student> searchStudent(@PathVariable String word){
        return new ResponseEntity(instructorService.search(word),HttpStatus.OK);
    }

}
