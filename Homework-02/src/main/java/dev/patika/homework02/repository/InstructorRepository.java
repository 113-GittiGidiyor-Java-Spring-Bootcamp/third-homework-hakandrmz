package dev.patika.homework02.repository;

import dev.patika.homework02.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {

}