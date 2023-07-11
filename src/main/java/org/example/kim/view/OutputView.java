package org.example.kim.view;

import org.example.kim.message.FixedMessage;

import static org.example.kim.message.FixedMessage.*;

public class OutputView {

    public void printAppStart() {
        printMessage(TITLE.getMessage());
        printLine();
        printMessage(MENU.getMessage());
        printMessage(COMMAND_NUM.getMessage());
    }

    private void printLine() {
        printMessage(LINE.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }


    public void printInputScore() {
        printMessage(INPUT_SCORE_GUIDE.getMessage());
    }

    public void printInputStudentData() {
        printMessage(INPUT_STUDENT_DATA_GUIDE.getMessage());
    }
}
