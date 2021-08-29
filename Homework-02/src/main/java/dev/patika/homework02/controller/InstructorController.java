package dev.patika.homework02.controller;

import dev.patika.homework02.entity.Course;
import dev.patika.homework02.entity.Instructor;
import dev.patika.homework02.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("instructors")
    public ResponseEntity<Course> getAllInstructor(){
        return new ResponseEntity(instructorService.findAll(),HttpStatus.OK);
    }

    @PutMapping("instructor/update")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor){
        Instructor foundInstructor = instructorService.findById(instructor.getId());
        foundInstructor.setName(instructor.getName());
        foundInstructor.setAddress(instructor.getAddress());
        foundInstructor.setPhoneNumber(instructor.getPhoneNumber());
        foundInstructor.setSalary(instructor.getSalary());
        foundInstructor.setType(instructor.getType());
        instructorService.save(foundInstructor);
        return new ResponseEntity<>(foundInstructor,HttpStatus.OK);
    }

    @DeleteMapping("instructor")
    public ResponseEntity<Course> deleteCourse(@RequestBody Instructor instructor) {
        instructorService.deleteById(instructor.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/instructor/delete/{id}")
    public HttpStatus deleteInstructor(@PathVariable int id){
        instructorService.deleteById(id);
        return HttpStatus.OK;
    }



}
