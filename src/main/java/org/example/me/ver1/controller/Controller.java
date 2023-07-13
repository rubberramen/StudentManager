package org.example.me.ver1.controller;

import org.example.me.ver1.entity.Student;
import org.example.me.ver1.model.StudentRepository;
import org.example.me.ver1.view.View;

import java.util.List;

public class Controller {

    private final StudentRepository repository;
    private final View view;

    public Controller(StudentRepository repository, View view) {
        this.repository = repository;
        this.view = view;
    }

    public void run() {
        repository.initRepo();
        view.startApp();

        while (true) {
            view.menuGuide();
            int menu = view.selectMenu();

            switch (menu) {
                case 1 :
                    view.insertStudentTitle();
                    insertStudent();
                    break;
                case 2 :
                    view.allStudentListTitle();
                    allStudentList();
                    break;
                case 3 :
                    view.searchStudentTitle();
                    searchStudent();
                    break;
                case 0 :
                    view.exitApp();
                    return;
                default:
                    view.menuSelectionErrTitle();
            }
        }
    }

    public void insertStudent() {
        Student student = view.inputStudentData();
        repository.add(student);
    }

    public void allStudentList() {
        List<Student> allStudents = repository.findAll();
        view.printAllStudent(allStudents);
    }

    // TODO: 2023-07-14 014  
    public void searchStudent() {
        String name = view.inputStudentName();
        Student student = repository.findByName(name);

        if (!(student == null)) {
            view.printStudent(student);
        } else {
            view.noStudent();
        }
    }
}
