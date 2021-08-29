package dev.patika.homework02.repository;

import dev.patika.homework02.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("select s.gender, count(s.gender) from Student s GROUP BY s.gender")
    List<?> getGendersWithGrouping();
    void deleteByName(String name);

}
