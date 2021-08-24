package dev.patika.homework02.dao;

import dev.patika.homework02.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDao extends CrudRepository<Instructor,Integer> {



}
