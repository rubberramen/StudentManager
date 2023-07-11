package org.example.kim.dto;

import org.example.kim.entity.Score;
import org.example.kim.entity.Student;


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

    public String makeOutputFormat() {
        return String.format("%8d%6s%8d%8d%8d%8d%10.1f",
                studentId,
                student.getName(),
                score.getKorScore(),
                score.getEngScore(),
                score.getMathScore(),
                score.getTotalScore(),
                score.getAvgScore());
    }
}
