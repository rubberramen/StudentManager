package org.example.kim.controller;

import org.example.kim.command.Command;
import org.example.kim.dto.ReplyDTO;
import org.example.kim.dto.ResultDTO;
import org.example.kim.dto.ScoreDTO;
import org.example.kim.dto.StudentDTO;
import org.example.kim.service.StudentScoreManagementService;
import org.example.kim.view.InputView;
import org.example.kim.view.OutputView;

import java.util.Arrays;
import java.util.List;
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

//        Command[] values = Command.values();

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
                // TODO: 2023-07-13 013
                updateScore();
                break;
            case DELETE_SCORE:
                // TODO: 2023-07-13 013
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

        // TODO: 2023-07-12 012 ReplyDTO : Request 개념.
        management.addStudentAndScore(new ReplyDTO(newStudent, newScore));
    }

    private void searchScore() {
        Integer studentIdValue = printStudentsAndInputStudentId();
        outputView.printSearchResult(management.findStudent(studentIdValue));
    }

    private void readAll() {
        List<ResultDTO> all = management.findAll();
        outputView.printAll(all);
    }

    private void updateScore() {

    }

    private void deleteScore() {

    }

    // ===========================================================================

    private Integer printStudentsAndInputStudentId() {
        outputView.printStudents(management.findStudents());
        outputView.printInputId();
        return repeat(inputView::inputStudentId);
    }

    private ScoreDTO inputScore() {
        outputView.printInputScore();
        return repeat(inputView::inputScore);
    }


    // TODO: 2023-07-12 012 // Supplier 매개 없고, 반환 타입이 없는 메서드 사용 가능.
    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            return repeat(inputReader);
        }
    }

    // TODO: 2023-07-13
//    private <T extends Animal> T add(List<T> aninalList)
}
