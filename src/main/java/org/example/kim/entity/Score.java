package org.example.kim.entity;

import java.lang.reflect.Field;

public class Score {

    private int korScore;
    private int engScore;
    private int mathScore;

    public Score() {

    }

    public Score(int korScore, int engScore, int mathScore) {
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public int getKorScore() {
        return korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (Field declaredField : this.getClass().getDeclaredFields()) {
            try {
                totalScore += (int) declaredField.get(this);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return totalScore;
    }

    public float getAvgScore() {
        return (float) getTotalScore() / this.getClass().getDeclaredFields().length;
    }
}
