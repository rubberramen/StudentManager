package org.example.me.ver1.entity;

public class Student {

    int stuNo;
    String stuName;
    int korScore;
    int engScore;
    int mathScore;
    private int sum;
    private float average;

    public Student() {
    }

    public Student(int stuNo, String stuName, int korScore, int engScore, int mathScore) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;

        this.sum = korScore + engScore + mathScore;
        this.average = (float) (this.sum / 3.0);
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
        return  "학번 = " + stuNo +
                ", 이름 = " + stuName +
                ", 언어 점수 = " + korScore +
                ", 영어 점수 = " + engScore +
                ", 수학 점수 = " + mathScore +
                ", 합계 = " + sum +
                ", 평균 = " + average;
    }

    //    // 총점 구하는 메서드.
//    public int getTotScore() {
//        return korScore + engScore + mathScore;
//    }
//
//    // 평균 구하는 메서드.
//    public float getAvgScore() {
//        return getTotScore() / 3.0f;
//    }
}
