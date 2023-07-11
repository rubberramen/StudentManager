package org.example.kim.dto;

import org.example.kim.entity.Score;

import java.util.HashMap;
import java.util.Map;

import static org.example.kim.message.ErrorMessage.INSUFFICIENT_VALUE_COUNT;
import static org.example.kim.message.ErrorMessage.INVALID_VALUE;

public class ScoreDTO {

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    private final Map<String, Integer> scores;   // 과목, 점수

    public ScoreDTO(String[] scores) {
        // TODO: 2023-07-11 reflection? 
        int scoreFieldCount = Score.class.getDeclaredFields().length;
        validate(scoreFieldCount, scores);
        this.scores = new HashMap<>();

        // TODO: 2023-07-11 011  : index 순서대로 필드명 받아오는 거?
        for (int index = 0; index < scoreFieldCount; index++) {
            this.scores.put(Score.class.getDeclaredFields()[index].getName(), Integer.valueOf(scores[index]));
        }
    }

    private void validate(int scoreFieldCount, String[] scores) {
        int scoresLength = scores.length;
        checkCountOfValues(scoreFieldCount, scoresLength);
    }

    private void checkCountOfValues(int scoreFieldCount, int inputScoreLength) {
        if (scoreFieldCount != inputScoreLength) {
            throw new IllegalArgumentException(INSUFFICIENT_VALUE_COUNT.getMessage());
        }
    }


    private static void checkInvalidScore(int score) {
        if (!(MIN_SCORE <= score && score <= MAX_SCORE)) {
            throw new IllegalArgumentException(INVALID_VALUE.getMessage());
        }
    }

    // TODO: 2023-07-11 왜 new HashMap? 
    public Map<String, Integer> getScores() {
        return new HashMap<>(scores);  // 원본 데이터 지키기 위해
    }
}
