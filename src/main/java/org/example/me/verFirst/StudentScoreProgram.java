package org.example.me.verFirst;

import java.util.List;
import java.util.Scanner;

public class StudentScoreProgram {

    private static Scanner sc = new Scanner(System.in);
    private static final MemoryStudentRepo repo = new MemoryStudentRepo();

    public static void main(String[] args) {

        // 샘플 데이터 입력
        inputSampleData();

        System.out.println("==================================================================");
        System.out.println("                      <🏫 학생 점수 프로그램>                       ");
        System.out.println("==================================================================");

        // 본격 프로그램 시작
        while (true) {

            // 메뉴 안내
            System.out.println();
            System.out.println("* 메뉴를 선택하세요(🚩반드시 정수 입력. 정수 입력 안하면 )");   // 정수 외 입력 받았을 때 방어 로직 작성 예정
            System.out.println("==================================================================");
            System.out.println("1 : 학생 데이터 입력 / 2 : 전체 학생 점수 리스트 / 3 : 학생 검색 / 4 : 학생 정보 수정 / 0 : 😛프로그램 종료");

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1 :
                    System.out.println("== 학생 데이터 입력 ==");
                    inputStudentInfo();
                    break;
                case 2 :
                    System.out.println("== 전체 학생 점수 리스트 ==");
                    studentScoreList();
                    break;
                case 3 :
                    System.out.println("== 학생 검색 ==");
                    searchStudent();
                    break;
                case 4 :
                    System.out.println("== 학생 정보 수정 ==");
                    updateStudentInfo();
                    break;
                case 0 :
                    System.out.println("== 프로그램 종료 : 수고염 Bye😉~ ==");
                    return;
                default:
                    System.out.println("== 🪓메뉴 선택 오류 : 응 다시 선택해~  ==");
            }
        }
    }

    public static void inputSampleData() {
        StudentInfo studentInfo1 = new StudentInfo("홍길동", 89, 79, 95);
        StudentInfo studentInfo2 = new StudentInfo("이순신", 85, 66, 93);
        StudentInfo studentInfo3 = new StudentInfo("강감찬", 91, 71, 87);

        repo.save(studentInfo1);
        repo.save(studentInfo2);
        repo.save(studentInfo3);
    }

    public static void studentScoreList() {
        List<StudentInfo> allStudent = repo.findAll();
        for (StudentInfo studentInfo : allStudent) {
            System.out.println("studentInfo = " + studentInfo);
        }

        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }

    public static void inputStudentInfo() {
        System.out.println();
        System.out.print("이름 : ");
        String name = sc.next();

        System.out.print("국어 점수 : ");
        int korScore = sc.nextInt();

        System.out.print("영어 점수 : ");
        int engScore = sc.nextInt();

        System.out.print("수학 점수 : ");
        int mathScore = sc.nextInt();

        StudentInfo studentInfo = new StudentInfo(name, korScore, engScore, mathScore);
        repo.save(studentInfo);

        System.out.println();
        System.out.println("<학생 정보가 입력되었습니다!>");
        System.out.print("입력한 학생 정보 : ");
        System.out.println(studentInfo);

        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }

    public static void searchStudent() {
        System.out.println();
        System.out.println("== 학생 검색");
        System.out.print("[이름 검색] : ");
        String name = sc.next();

        StudentInfo student = repo.findByName(name);

        System.out.println("[검색 결과] ");
        System.out.println("student = " + student);

        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }

    public static void updateStudentInfo() {
        System.out.println();
        System.out.print("[이름 검색] : ");
        String name = sc.next();

        StudentInfo student = repo.findByName(name);

        System.out.print("국어 점수 : ");
        int korScore = sc.nextInt();

        System.out.print("영어 점수 : ");
        int engScore = sc.nextInt();

        System.out.print("수학 점수 : ");
        int mathScore = sc.nextInt();

        int sum = korScore + engScore + mathScore;
        float average = (float) (sum / 3.0);

        student.setKorScore(korScore);
        student.setEngScore(engScore);
        student.setMathScore(mathScore);
        student.setSum(sum);
        student.setAverage(average);

        System.out.print("[수정 완료] ");
        System.out.println("student = " + student);
        System.out.println();

        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }
}
