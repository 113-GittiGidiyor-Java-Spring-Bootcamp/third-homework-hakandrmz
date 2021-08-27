package dev.patika.homework02.service.concrete;

import dev.patika.homework02.repository.StudentDao;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id :" + id));
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public void update(Student student) {
        studentDao.save(student);
    }
}
