package org.example.teacher.examPrac;

import org.example.teacher.examPrac.entity.StudentEntity;
import org.example.teacher.examPrac.controller.Controller;
import org.example.teacher.examPrac.entity.Student;

public class StudentManagerApp {
    public static void main(String[] args) {
        Controller controller = new Controller();

        initController(controller);

        insertStudent(controller);

        insertStudent(controller);
    }

    private static void initController(Controller controller) {
        // 배열의 길이는 5이고, 샘플 데이터를 입력함
        int result = controller.initController(5, true);

        if (result == Controller.INFO_SUCCESS) {
            controller.searchAllStudent();
        } else {
            System.out.println("프로그램에서 사용할 배열의 길이를 다시 확인해 주세요.");
        }
    }

    private static void insertStudent(Controller controller) {
        Student student = new Student();
        student.setStuName("Student");
        student.setKorScore(80);
        student.setEngScore(90);
        student.setMathScore(79);

        int result = controller.insertStudent(student);

        // 결과 확인.
        if (result == StudentEntity.ERR_ARRAY_Full) {
            System.out.println("배열에는 저장할 공간이 없습니다.");
        } else {
            controller.searchAllStudent();
        }
    }
}
