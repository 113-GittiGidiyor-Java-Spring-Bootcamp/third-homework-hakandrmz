package dev.patika.homework02.service.concrete;

import dev.patika.homework02.repository.StudentRepository;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id :" + id));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }
}
