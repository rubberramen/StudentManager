package org.example.me.ver1.model;

import org.example.me.ver1.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

    private static List<Student> store = new ArrayList<>();

    @Override
    public void add(Student student) {
        store.add(student);
    }

    @Override
    public Student findById(int stuNo) {

        for (Student student : store) {
            if (student.getStuNo() == stuNo) {
                return student;
            }
        }
        // TODO: 2023-07-13
        return null;
    }

    @Override
    public void remove(int stuNo) {
        Student student = findById(stuNo);
        store.remove(student);
    }

    @Override
    public List<Student> findAll() {
        return store;
    }
}
