package org.example.kim.service;

import org.example.kim.dto.ReplyDTO;
import org.example.kim.entity.Score;
import org.example.kim.entity.Student;
import org.example.kim.repository.ScoreRepository;
import org.example.kim.repository.StudentRepository;

public class StudentScoreManagementService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentScoreManagementService() {
        this.studentRepository = new StudentRepository();
        this.scoreRepository = new ScoreRepository();
        init();
    }

    private void init() {
        studentRepository.add(new Student("김동욱"));
        scoreRepository.insertScore(studentRepository.getId(), new Score(100, 100, 100));

        studentRepository.add(new Student("김경욱"));
        scoreRepository.insertScore(studentRepository.getId(), new Score(100, 100, 100));

        studentRepository.add(new Student("송정희"));
        scoreRepository.insertScore(studentRepository.getId(), new Score(100, 100, 100));

        studentRepository.add(new Student("이수민"));
        scoreRepository.insertScore(studentRepository.getId(), new Score(100, 100, 100));
    }

    public void addStudentAndScore(ReplyDTO replyDTO) {

    }
}
