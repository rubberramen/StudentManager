package org.example.teacher.examPrac.view;

import org.example.teacher.examPrac.entity.Student;

public class StudentView {

    public void printTitle() {
        System.out.println("===========================================================");
        System.out.println("학번\t이름\t\t국어\t영어\t수학\t총점\t평균\t");
        System.out.println("===========================================================");
    }

    // 꼬리 출력
    public void printTail() {
        System.out.println("===========================================================");
    }

    public void printAllStudent(Student[] stuArr, int stuMaxNo) {
        printTitle();

        for (int i = 0; i < stuMaxNo; i++) {
            System.out.printf("%3d\t%8s\t%3d\t%3d\t%3d\t%3d\t%.1f%n",
                    stuArr[i].getStuNo(),
                    stuArr[i].getStuName(),
                    stuArr[i].getKorScore(),
                    stuArr[i].getEngScore(),
                    stuArr[i].getMathScore(),
                    stuArr[i].getTotScore(),
                    stuArr[i].getAvgScore()
            );
        }
        printTail();
    }

}
