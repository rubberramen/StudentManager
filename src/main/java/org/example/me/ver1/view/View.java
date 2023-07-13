package org.example.me.ver1.view;

import org.example.me.ver1.entity.Student;

import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public void startApp() {
        System.out.println("==================================================================");
        System.out.println("           <🏫 학생 점수 프로그램> : ver 2 : MVC1            ");
        System.out.println("==================================================================");
    }

    public void menuGuide() {
        System.out.println();
        System.out.println("* 메뉴를 선택하세요(🚩반드시 정수 입력. 정수 입력 안하면 울꼬얌😢)");   // 정수 외 입력 받았을 때 방어 로직 필요
        System.out.println("==================================================================");
        System.out.println("1 : 학생 데이터 입력 / 2 : 전체 학생 점수 리스트 / 3 : 학생 검색 / 0 : 😛프로그램 종료");
    }

    public int selectMenu() {
        System.out.print("메뉴 선택 : ");
        return sc.nextInt();
    }

    public void insertStudentTitle() {
        System.out.println("== 학생 데이터 입력 ==");
    }

    public void allStudentListTitle() {
        System.out.println("== 전체 학생 점수 리스트 ==");
    }

    public void searchStudentTitle() {
        System.out.println("== 학생 검색 ==");
    }

    public void exitApp() {
        System.out.println("== 프로그램 종료 : 수고염 Bye😉~ ==");
    }

    public void menuSelectionErrTitle() {
        System.out.println("== 🪓메뉴 선택 오류 : 응 다시 선택해~  ==");
    }

    public Student inputStudentData() {
        System.out.print("학번 : ");
        int stuNo = sc.nextInt();

        System.out.print("이름 : ");
        String stuName = sc.next();

        System.out.print("국어 점수 : ");
        int korScore = sc.nextInt();

        System.out.print("영어 점수 : ");
        int engScore = sc.nextInt();

        System.out.print("수학 점수 : ");
        int mathScore = sc.nextInt();

        Student student = new Student(stuNo, stuName, korScore, engScore, mathScore);

        return student;
    }

    public void printAllStudent(List<Student> allStudents) {
        System.out.println("학번      이름      국어      영어    수학    총점      평균");
        System.out.println("==========================================================");

        for (Student student : allStudents) {
            System.out.printf("%3d", student.getStuNo());
            System.out.printf("\t\t%3s", student.getStuName());
            System.out.printf("\t\t%3d", student.getKorScore());
            System.out.printf("\t\t%3d", student.getEngScore());
            System.out.printf("\t\t%3d", student.getMathScore());
            System.out.printf("\t\t%3d \t%3.1f%n", student.getSum(), student.getAverage());
        }

        System.out.println("==========================================================");

        int korTotal = 0;
        int engTotal = 0;
        int mathTotal = 0;

        for (Student student : allStudents) {
            korTotal += student.getKorScore();
            engTotal += student.getEngScore();
            mathTotal += student.getMathScore();
        }

        System.out.printf("[과목별 총점] 국어 : %5d // 영어 : %5d // 수학 : %5d%n", korTotal, engTotal, mathTotal);
        System.out.println();
    }

    public String inputStudentName() {
        System.out.println();
        System.out.print("[이름 검색어 입력] : ");
        String name = sc.next();
        return name;
    }

    public void printStudent(Student student) {
        System.out.println(student);
    }

    public void noStudent() {
        System.out.println("그딴 학생 없다🥶");
    }
}
