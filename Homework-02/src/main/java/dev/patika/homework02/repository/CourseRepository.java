package dev.patika.homework02.repository;

import dev.patika.homework02.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {
}
