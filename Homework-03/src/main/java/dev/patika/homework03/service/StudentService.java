package dev.patika.homework03.service;

import dev.patika.homework03.entity.Student;

import java.util.List;

public interface StudentService extends BaseService<Student>{
    List<?> getGendersWithGrouping();
    void deleteByName(String name);
    List<Student> search(String word);
}
