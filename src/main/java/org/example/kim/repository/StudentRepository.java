package org.example.kim.repository;

import org.example.kim.entity.Student;
import org.example.kim.message.ErrorMessage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static org.example.kim.message.ErrorMessage.NOT_EXIST_STUDENT_ID;

public class StudentRepository {

    private static int studentId = 20230000;

    private final Map<Integer, Student> students = new LinkedHashMap<>();

    public void add(Student student) {
        students.put(++studentId, student);
    }

    public void remove(Integer id) {
        students.remove(id);
    }

    public Student findById(Integer id) {
        Optional<Student> student = Optional.ofNullable(students.get(id));

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new NullPointerException(NOT_EXIST_STUDENT_ID.getMessage());
        }
    }

    public Map<Integer, Student> findAll() {
        return new LinkedHashMap<>(students);
    }

    public Integer getId() {
        return studentId;
    }
}
