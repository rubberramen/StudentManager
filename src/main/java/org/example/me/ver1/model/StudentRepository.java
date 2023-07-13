package org.example.me.ver1.model;

import org.example.me.ver1.entity.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentRepository {

    void add(Student student);

    Student findById(int stuNo);

    void remove(int stuNo);

    List<Student> findAll();

//    Integer getId();
}
