package dev.patika.homework02.dao;

import dev.patika.homework02.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student,Integer> {
}
