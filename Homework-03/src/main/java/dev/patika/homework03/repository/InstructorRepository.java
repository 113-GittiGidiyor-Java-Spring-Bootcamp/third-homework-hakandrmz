package dev.patika.homework03.repository;

import dev.patika.homework03.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {

}
