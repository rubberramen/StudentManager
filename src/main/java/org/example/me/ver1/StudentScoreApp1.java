package org.example.me.ver1;

import org.example.me.ver1.controller.Controller;
import org.example.me.ver1.model.StudentRepository;
import org.example.me.ver1.view.View;

public class StudentScoreApp1 {

    public static void main(String[] args) {
        Controller controller = new Controller(new StudentRepository(), new View());

        controller.run();
    }
}
