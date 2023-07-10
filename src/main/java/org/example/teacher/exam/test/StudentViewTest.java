package org.example.teacher.exam.test;


import org.example.teacher.exam.controller.Controller;
import org.example.teacher.exam.entity.Student;
import org.example.teacher.exam.entity.StudentEntity;

public class StudentViewTest {

    public static void main(String[] args) {
        Controller controller = new Controller();

        // 초기화 및 샘플 데이터 등록 기능 테스트
        initControllerTest(controller);

        // 한건 등록하는 기능 테스트
        insertStudentTest(controller);

        // 한건 등록하는 기능 테스트
        insertStudentTest(controller);
    }

    /**
     * 배열 생성과 샘플 데이터 입력 테스트 메소드
     * @param controller
     */
    public static void initControllerTest(Controller controller) {
        // 배열의 길이는 5이고, 샘플 데이터를 입력함
        int result = controller.initController(5, true);

        if (result == Controller.INFO_SUCCESS) {
            controller.searchAllStudent();
        } else {
            System.out.println("프로그램에서 사용할 배열의 길이를 다시 확인해 주세요.");
        }
    }

    /**
     * 학생 한명의 데이터를 등록하는 테스트 메소드
     * @param controller
     */
    public static void insertStudentTest(Controller controller) {
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
