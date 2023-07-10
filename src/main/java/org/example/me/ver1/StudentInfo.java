package org.example.me.ver1;

public class StudentInfo {

    private int id;
    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;
    private int sum;
    private float average;

    public StudentInfo() {
    }

    public StudentInfo(int id, String name, int korScore, int engScore, int mathScore) {
        this.id = id;
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;

        this.sum = korScore + engScore + mathScore;
        this.average = (float) (this.sum / 3.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return  "이름='" + name + '\'' +
                ", 언어 점수=" + korScore +
                ", 영어 점수=" + engScore +
                ", 수학 점수=" + mathScore +
                ", 합계=" + sum +
                ", 평균=" + average;
    }
}
