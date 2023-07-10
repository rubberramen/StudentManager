package org.example.teacher.exam;

import org.example.teacher.exam.controller.Controller;
import org.example.teacher.exam.entity.Student;
import org.example.teacher.exam.entity.StudentEntity;

/**
 * 학생 정보 및 성적 관리를 위한 프로그램의 main() 메서드가 있는 시작 클래스.
 * 3Tier 아키텍처의 client 역할을 담당.
 */
public class StudentManagerApp {

    public static void main(String[] args) {
        Controller controller = new Controller();

        // 초기화 및 샘플 데이터 등록 기능 테스트
        initController(controller);

        // 한건 등록하는 기능 테스트
        insertStudent(controller);

        // 한건 등록하는 기능 테스트
        insertStudent(controller);
    }

    public static void initController(Controller controller) {
        // 배열의 길이는 5이고, 샘플 데이터를 입력함
        int result = controller.initController(5, true);

        if (result == Controller.INFO_SUCCESS) {
            controller.searchAllStudent();
        } else {
            System.out.println("프로그램에서 사용할 배열의 길이를 다시 확인해 주세요.");
        }
    }

    public static void insertStudent(Controller controller) {
        // 학생 객체 생성
        Student stu = new Student();
        stu.setStuName("Student");
        stu.setKorScore(80);
        stu.setEngScore(90);
        stu.setMathScore(79);

        // controller 통해서 학생 한명 등록 메소드 호출
        int result = controller.insertStudent(stu);

        // 결과 확인.
        if (result == StudentEntity.ERR_ARRAY_Full) {
            System.out.println("배열에는 저장할 공간이 없습니다.");
        } else {
            controller.searchAllStudent();
        }
    }
}
