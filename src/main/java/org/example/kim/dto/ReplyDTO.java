package org.example.kim.dto;

public class ReplyDTO {

    private final StudentDTO student;

    private final ScoreDTO score;

    public ReplyDTO(StudentDTO studentDTO, ScoreDTO scoreDTO) {
        this.student = studentDTO;
        this.score = scoreDTO;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public ScoreDTO getScore() {
        return score;
    }
}
