package org.example.teacher.examPrac.controller;

import org.example.teacher.examPrac.entity.Student;
import org.example.teacher.examPrac.entity.StudentEntity;
import org.example.teacher.examPrac.view.StudentView;

public class Controller {

    StudentEntity studentEntity;
    StudentView studentView;

    public static int ERR_ARRAY_LENGTH = 0;
    public static int INFO_SUCCESS = 1;
    public static int DEFAULT_ARRAY_LENGTH = 6;

    public int initController(int arrLength, boolean sampleDataInsert) {
        if (arrLength < 1) {
            return Controller.ERR_ARRAY_LENGTH;
        }

        if (arrLength <= 5) {
            arrLength = Controller.DEFAULT_ARRAY_LENGTH;   // 6
        }

        studentEntity = new StudentEntity();

        initEntity(arrLength, sampleDataInsert);

        studentView = new StudentView();

        return Controller.INFO_SUCCESS;
    }

    public void searchAllStudent() {
        studentView.printAllStudent(studentEntity.getStuArr(), studentEntity.getNextArrIdx());
    }

    public int insertStudent(Student student) {
        int result = studentEntity.insertStudent(student);
        return result;
    }

    public void initEntity(int arrLength, boolean sampleDataInsert) {
        studentEntity.initStudentEntity(arrLength, sampleDataInsert);
    }


}
