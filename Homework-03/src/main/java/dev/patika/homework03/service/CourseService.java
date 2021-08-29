package dev.patika.homework03.service;

import dev.patika.homework03.entity.Course;
import dev.patika.homework03.entity.Student;

import java.util.List;

public interface CourseService extends BaseService<Course>{
    List<Course> search(String word);
}
