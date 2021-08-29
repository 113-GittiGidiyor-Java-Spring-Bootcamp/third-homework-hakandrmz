package dev.patika.homework03.service.concrete;

import dev.patika.homework03.repository.StudentRepository;
import dev.patika.homework03.entity.Student;
import dev.patika.homework03.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Student foundStudent = studentRepository.findById(student.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid student id :" + student.getId()));
        foundStudent.setName(student.getName());
        foundStudent.setAddress(student.getAddress());
        foundStudent.setGender(student.getGender());
        studentRepository.save(student);
    }

    public List<?> getGendersWithGrouping() {
        return studentRepository.getGendersWithGrouping();
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        studentRepository.deleteByName(name);
    }

    @Override
    public List<Student> search(String word) {
        return studentRepository.search(word);
    }
}
