package org.example.teacher.exam.view;


import org.example.teacher.exam.entity.Student;

/**
 * 성적 관리 프로그램의 출력과 관련된 기능적인 요소를 구현한 클래스.
 */
public class StudentView {

    // 타이틀 출력
    public void printTitle() {
        System.out.println("===========================================================");
        System.out.println("학번\t이름\t\t국어\t영어\t수학\t총점\t평균\t");
        System.out.println("===========================================================");
    }

    // 본문 출력
    public void printAllStudent(Student[] stuArr, int stuMaxNo) {
        printTail();

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

    // 꼬리 출력
    public void printTail() {
        System.out.println("===========================================================");
    }

}
