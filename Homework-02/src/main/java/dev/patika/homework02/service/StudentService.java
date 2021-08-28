package dev.patika.homework02.service;

import dev.patika.homework02.entity.Student;

import java.util.List;

public interface StudentService extends BaseService<Student>{
    List<?> getGendersWithGrouping();
    void deleteByName(String name);
}
