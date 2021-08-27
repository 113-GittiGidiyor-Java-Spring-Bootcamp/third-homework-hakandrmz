package dev.patika.homework02.service.concrete;

import dev.patika.homework02.repository.CourseDao;
import dev.patika.homework02.entity.Course;
import dev.patika.homework02.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseDao.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id :" + id));
    }

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }

    @Override
    public void update(Course course) {
        courseDao.save(course);
    }
}
