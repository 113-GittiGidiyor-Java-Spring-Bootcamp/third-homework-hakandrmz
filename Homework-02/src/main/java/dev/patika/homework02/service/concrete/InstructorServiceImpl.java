package dev.patika.homework02.service.concrete;

import dev.patika.homework02.dao.InstructorDao;
import dev.patika.homework02.entity.Instructor;
import dev.patika.homework02.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao;

    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> findAll() {
        return (List<Instructor>) instructorDao.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return instructorDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id :" + id));
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorDao.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDao.deleteById(id);
    }

    @Override
    public void update(Instructor instructor) {
        instructorDao.save(instructor);
    }


}
