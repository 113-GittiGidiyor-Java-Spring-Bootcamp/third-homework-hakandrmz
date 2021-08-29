package dev.patika.homework03.repository;

import dev.patika.homework03.entity.Instructor;
import dev.patika.homework03.entity.Student;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
    @Query("SELECT i FROM Instructor i WHERE i.name LIKE %?1%"
            +" OR i.address LIKE %?1%"
            +" OR i.phoneNumber LIKE %?1%")
    List<Instructor> search(String word);

}
