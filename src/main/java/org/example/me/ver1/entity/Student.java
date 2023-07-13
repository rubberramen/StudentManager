package org.example.me.ver1.entity;

public class Student {

    int stuNo;
    String stuName;
    int korScore;
    int engScore;
    int mathScore;

    public Student(int stuNo, String stuName, int korScore, int engScore, int mathScore) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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

    // 총점 구하는 메서드.
    public int getTotScore() {
        return korScore + engScore + mathScore;
    }

    // 평균 구하는 메서드.
    public float getAvgScore() {
        return getTotScore() / 3.0f;
    }
}
