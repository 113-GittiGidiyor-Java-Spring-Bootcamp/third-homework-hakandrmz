package dev.patika.homework03.service.concrete;

import dev.patika.homework03.repository.CourseRepository;
import dev.patika.homework03.entity.Course;
import dev.patika.homework03.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course id :" + id));
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void update(Course course) {
        Course willUpdateCourse = courseRepository.findById(course.getId()).orElseThrow(() -> new IllegalArgumentException());
        willUpdateCourse.setName(course.getName());
        willUpdateCourse.setCourseCode(course.getCourseCode());
        willUpdateCourse.setCredit(course.getCredit());
        courseRepository.save(course);
    }


    @Override
    public List<Course> search(String word) {
        return courseRepository.search(word);
    }
}
