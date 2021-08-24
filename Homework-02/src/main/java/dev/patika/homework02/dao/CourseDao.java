package dev.patika.homework02.dao;

import dev.patika.homework02.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends CrudRepository<Course,Integer> {
}
