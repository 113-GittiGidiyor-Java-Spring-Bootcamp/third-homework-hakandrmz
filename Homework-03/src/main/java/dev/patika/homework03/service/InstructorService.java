package dev.patika.homework03.service;

import dev.patika.homework03.entity.Instructor;
import io.swagger.models.auth.In;

import java.util.List;

public interface InstructorService extends BaseService<Instructor> {
    List<Instructor> search(String word);
}
