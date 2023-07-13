package org.example.me.ver1.model;

import org.example.me.ver1.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static List<Student> store = new ArrayList<>();

    public void initRepo() {
        Student student1 = new Student(1, "김유범", 89, 79, 95);
        Student student2 = new Student(2, "정진우", 80, 89, 90);
        Student student3 = new Student(3, "박소희", 55, 72, 99);
        Student student4 = new Student(4, "옥승철", 75, 83, 85);
        Student student5 = new Student(5, "왕찬현", 65, 67, 69);

        store.add(student1);
        store.add(student2);
        store.add(student3);
        store.add(student4);
        store.add(student5);
    }

    public static List<Student> getStore() {
        return store;
    }

    public void add(Student student) {
        store.add(student);
    }

    public Student findById(int stuNo) {

        for (Student student : store) {
            if (student.getStuNo() == stuNo) {
                return student;
            }
        }
        // TODO: 2023-07-13
        return null;
    }

    public Student findByName(String name) {
        for (Student student : store) {
            if (student.getStuName().equals(name)) {
                return student;
            }
        }

        return null;
    }

    public void remove(int stuNo) {
        Student student = findById(stuNo);
        store.remove(student);
    }

    public List<Student> findAll() {
        return store;
    }
}
