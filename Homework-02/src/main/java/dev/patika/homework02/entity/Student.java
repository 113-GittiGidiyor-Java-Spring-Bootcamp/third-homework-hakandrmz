package dev.patika.homework02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

}
