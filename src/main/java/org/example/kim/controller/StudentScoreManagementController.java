package org.example.kim.controller;

import org.example.kim.command.Command;
import org.example.kim.dto.ReplyDTO;
import org.example.kim.dto.ScoreDTO;
import org.example.kim.dto.StudentDTO;
import org.example.kim.service.StudentScoreManagementService;
import org.example.kim.view.InputView;
import org.example.kim.view.OutputView;

import java.util.Arrays;
import java.util.function.Supplier;

import static org.example.kim.command.Command.EXIT;

public class StudentScoreManagementController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StudentScoreManagementService management;
    private boolean exitFlag;

    public StudentScoreManagementController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.management = new StudentScoreManagementService();
        this.exitFlag = false;
    }

    public void run() {
        do {
            try {
                choiceCommand();
            } catch (RuntimeException exception) {
                outputView.printMessage(exception.getMessage());
            } finally {
                choiceCommand();
            }
        } while (!exitFlag);
    }

    // ==========================================

    private void choiceCommand() {
        outputView.printAppStart();
        // TODO: 2023-07-12 012 repeat() method
        String inputCommandValue = repeat(inputView::inputCommand);

        // TODO: 2023-07-12 012
        Command inputCommand = Arrays.stream(Command.values())
                .filter(command -> command.equalCommand(inputCommandValue))
                .findAny().orElseGet(() -> EXIT);

        switch (inputCommand) {
            case ADD_STUDENT_AND_SCORE:
                create();
                break;
            case SEARCH:
                searchScore();
                break;
            case STUDENT_SCORE_LIST:
                readAll();
                break;
            case MODIFY_SCORE:
                updateScore();
                break;
            case DELETE_SCORE:
                deleteScore();
                break;
            default:
                exitFlag = true;
                System.exit(0);
        }
    }

    private void create() {
        outputView.printInputStudentData();
        StudentDTO newStudent = repeat(inputView::inputStudentData);
        ScoreDTO newScore = inputScore();

        // TODO: 2023-07-12 012 ReplyDTO 왜 이름을 이렇게 지은 거지?
        management.addStudentAndScore(new ReplyDTO(newStudent, newScore));
    }

    // TODO: 2023-07-12 012 할 예정

    private void searchScore() {

    }

    private void readAll() {

    }

    private void updateScore() {

    }

    private void deleteScore() {

    }

    // ====================

    private ScoreDTO inputScore() {
        outputView.printInputScore();
        return repeat(inputView::inputScore);
    }


    // TODO: 2023-07-12 012 // Supplier
    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            return repeat(inputReader);
        }
    }
}
