package org.example.kim.repository;

import org.example.kim.entity.Score;

import java.util.HashMap;
import java.util.Map;

public class ScoreRepository {

    private final Map<Integer, Score> scores = new HashMap<>();

    public void insertScore(Integer id, Score score) {
        scores.put(id, score);
    }

    public void removeAllScore(Integer id) {
        scores.remove(id);
    }

    public Score findById(Integer id) {
        return getScore(id);
    }

    private Score getScore(Integer id) {
        return scores.get(id);
    }
}
