package dev.patika.homework02.service.concrete;

import dev.patika.homework02.repository.InstructorRepository;
import dev.patika.homework02.entity.Instructor;
import dev.patika.homework02.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return instructorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id :" + id));
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void update(Instructor instructor) {
        instructorRepository.save(instructor);
    }

}
