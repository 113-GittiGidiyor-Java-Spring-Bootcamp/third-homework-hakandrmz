package dev.patika.homework02.bootstrap;

import dev.patika.homework02.entity.Course;
import dev.patika.homework02.entity.Instructor;
import dev.patika.homework02.entity.InstructorType;
import dev.patika.homework02.entity.Student;
import dev.patika.homework02.service.CourseService;
import dev.patika.homework02.service.InstructorService;
import dev.patika.homework02.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CourseService courseService;
    private final StudentService studentService;
    private final InstructorService instructorService;

    public DataLoader(CourseService courseService, StudentService studentService, InstructorService instructorService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.instructorService = instructorService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Student> Course1Students = new ArrayList<>();
        Course1Students.add(Student.builder().name("Sabri").address("Bursa").
                birthDate(LocalDate.of(1996,01,7)).gender("M").build());
        Course1Students.add(Student.builder().name("Özgür").address("Londra").
                birthDate(LocalDate.of(1995,02,7)).gender("M").build());
        Course1Students.add(Student.builder().name("Aydemir").address("Bukres").
                birthDate(LocalDate.of(1994,03,7)).gender("M").build());

        List<Student> Course2Students = new ArrayList<>();
        Course2Students.add(Student.builder().name("Hakan").address("Kutahya").
                birthDate(LocalDate.of(1999,05,7)).gender("M").build());
        Course2Students.add(Student.builder().name("Emre").address("Kayseri").
                birthDate(LocalDate.of(1998,06,7)).gender("M").build());
        Course2Students.add(Student.builder().name("Salih").address("Konya").
                birthDate(LocalDate.of(1997,07,7)).gender("M").build());

        courseService.save(Course.builder()
                .courseCode("CS101")
                .name("Computer Science101")
                .instructor(Instructor.builder()
                        .name("Şener")
                    .address("Bursa")
                    .phoneNumber("5432112341")
                    .salary(1111.0)
                    .type(InstructorType.VISITING).build())
                .students(Course1Students)
                .credit(6).build());

        courseService.save(Course.builder()
                .courseCode("CS103")
                .name("Computer Science103")
                .instructor(Instructor.builder()
                        .name("Hülya")
                        .address("Çanakkale")
                        .phoneNumber("5432112341")
                        .salary(1113.0)
                        .type(InstructorType.PERMANENT).build())
                .students(Course2Students)
                .credit(4).build());
    }
}
