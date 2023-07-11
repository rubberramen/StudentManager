package org.example.kim.service;

import org.example.kim.dto.ReplyDTO;
import org.example.kim.dto.ResultDTO;
import org.example.kim.dto.ScoreDTO;
import org.example.kim.dto.StudentDTO;
import org.example.kim.entity.Score;
import org.example.kim.entity.Student;
import org.example.kim.repository.ScoreRepository;
import org.example.kim.repository.StudentRepository;

import java.lang.reflect.Field;
import java.util.List;

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
        studentRepository.add(convertStudentDtoToStudentEntity(replyDTO.getStudent()));
        scoreRepository.insertScore(studentRepository.getId(), convertScoreDtoToScoreEntity(replyDTO.getScore()));
    }

    public ResultDTO findStudent(Integer studentId) {
        return null;
    }

    public List<ResultDTO> findStudents() {
        return null;
    }

    public List<ResultDTO> findAll() {
        return null;
    }

    public void modifyScore(Integer studentId, ScoreDTO modifyScore) {

    }

    public void deleteScore(Integer studentId) {

    }


    //===================================================================
    // TODO: 2023-07-11
    private Score convertScoreDtoToScoreEntity(ScoreDTO scoreDTO) {
        Score score = new Score();

        // TODO: 2023-07-11 reflection? 
        Field[] declaredFields = score.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (scoreDTO.getScores().containsKey(declaredField.getName())) {
                declaredField.setAccessible(true);  // ???
                try {
                    declaredField.set(score, scoreDTO.getScores().get(declaredField.getName()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                declaredField.setAccessible(false);
            }
        }
        return score;
    }

    private Student convertStudentDtoToStudentEntity(StudentDTO studentDTO) {
        return new Student(studentDTO.getName());
    }
}
