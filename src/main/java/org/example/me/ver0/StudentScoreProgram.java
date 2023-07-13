package org.example.me.ver0;

import java.util.Scanner;

public class StudentScoreProgram {

    private static final Scanner sc = new Scanner(System.in);

    // 학생 정보 담을 배열 생성(100명까지 가능)
    static StudentInfo[] studentInfos = new StudentInfo[100];
    static int index = 3;

    public static void main(String[] args) {

        inputSampleData();
        System.out.println("==================================================================");
        System.out.println("           <🏫 학생 점수 프로그램> : ver 0 : Basic            ");
        System.out.println("==================================================================");

        // 본격 프로그램 시작
        while (true) {
            // 메뉴 안내
            System.out.println();
            System.out.println("* 메뉴를 선택하세요(🚩반드시 정수 입력. 정수 입력 안하면 울꼬얌😢)");   // 정수 외 입력 받았을 때 방어 로직 필요
            System.out.println("==================================================================");
            System.out.println("1 : 학생 데이터 입력 / 2 : 전체 학생 점수 리스트 / 3 : 학생 검색 / 0 : 😛프로그램 종료");

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
                case 0 :
                    System.out.println("== 프로그램 종료 : 수고염 Bye😉~ ==");
                    return;
                default:
                    System.out.println("== 🪓메뉴 선택 오류 : 응 다시 선택해~  ==");
            }
        }
    }

    private static void inputStudentInfo() {
        StudentInfo studentInfo = new StudentInfo();

        System.out.print("학번 : ");
        int id = sc.nextInt();

        System.out.print("이름 : ");
        String name = sc.next();

        System.out.print("국어 점수 : ");
        int korScore = sc.nextInt();

        System.out.print("영어 점수 : ");
        int engScore = sc.nextInt();

        System.out.print("수학 점수 : ");
        int mathScore = sc.nextInt();

        int sum = korScore + engScore + mathScore;
        float average = (float) sum / 3;

        studentInfo.setId(id);
        studentInfo.setName(name);
        studentInfo.setKorScore(korScore);
        studentInfo.setEngScore(engScore);
        studentInfo.setMathScore(mathScore);
        studentInfo.setSum(sum);
        studentInfo.setAverage(average);

        studentInfos[index++] = studentInfo;

        System.out.println();
        System.out.println("<학생 정보가 입력되었습니다!😉>");
        System.out.println("입력한 학생 정보 : " + studentInfo);

        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }

    private static void studentScoreList() {

        // TODO: 2023-07-07 형식 맞게 출력.

        System.out.println("학번      이름      국어      영어    수학    총점      평균");
        System.out.println("==========================================================");

        for (int i = 0; i < index; i++) {
            System.out.printf("%3d", studentInfos[i].getId());
            System.out.printf("\t\t%3s", studentInfos[i].getName());
            System.out.printf("\t\t%3d", studentInfos[i].getKorScore());
            System.out.printf("\t\t%3d", studentInfos[i].getEngScore());
            System.out.printf("\t\t%3d", studentInfos[i].getMathScore());
            System.out.printf("\t\t%3d \t%3.1f%n", studentInfos[i].getSum(), studentInfos[i].getAverage());
        }
        System.out.println("==========================================================");

        int korTotal = 0;
        int engTotal = 0;
        int mathTotal = 0;

        for (int i = 0; i < index; i++) {
            korTotal += studentInfos[i].getKorScore();
            engTotal += studentInfos[i].getEngScore();
            mathTotal += studentInfos[i].getMathScore();
        }
        System.out.printf("과목별 총점 %5d %5d %5d%n", korTotal, engTotal, mathTotal);
        System.out.println();
    }

    private static void searchStudent() {

        System.out.println();
        System.out.print("[이름 검색어 입력] : ");
        String name = sc.next();

        StudentInfo studentInfo = null;

        for (int i = 0; i < index; i++) {
            if (studentInfos[i].getName().equals(name)) {
                studentInfo = studentInfos[i];
            }
        }

        if (studentInfo != null) {
            System.out.println(studentInfo);
        } else {
            System.out.println("그딴 학생 없다🥶");
        }
    }

    private static void inputSampleData() {
        StudentInfo studentInfo1 = new StudentInfo(1, "홍길동", 89, 79, 95);
        StudentInfo studentInfo2 = new StudentInfo(2, "강감찬", 80, 89, 90);
        StudentInfo studentInfo3 = new StudentInfo(3, "이순신", 55, 72, 85);

        studentInfos[0] = studentInfo1;
        studentInfos[1] = studentInfo2;
        studentInfos[2] = studentInfo3;
    }
}
