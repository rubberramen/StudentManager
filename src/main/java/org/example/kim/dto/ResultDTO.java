package org.example.kim.dto;

import org.example.kim.entity.Score;
import org.example.teacher.exam.entity.Student;

public class ResultDTO {

    private final int studentId;

    private final Student student;

    private final Score score;

    public ResultDTO(int studentId, Student student, Score score) {
        this.studentId = studentId;
        this.student = student;
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public Student getStudent() {
        return student;
    }

    public Score getScore() {
        return score;
    }
}
