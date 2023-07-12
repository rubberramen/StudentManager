package org.example.kim.view;

import org.example.kim.dto.ScoreDTO;
import org.example.kim.dto.StudentDTO;
import org.example.kim.validator.CommandValidator;
import org.example.kim.validator.IdValidator;
import org.example.kim.validator.Validator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputCommand() {
        Validator commandValidator = new CommandValidator();
        String command = getInputValue();
        return commandValidator.validate(command);
    }

    private String getInputValue() {
        String inputValue = null;
        // TODO: 2023-07-13 013 .hasNext() 사용 이유?
        if (scanner.hasNext()) {
            inputValue = scanner.nextLine();
        }
        return inputValue;
    }

    public StudentDTO inputStudentData() {
        String name = getInputValue();
        return new StudentDTO(name);
    }

    public ScoreDTO inputScore() {
        String score = getInputValue();
        String[] scores = score.split(" ");
        return new ScoreDTO(scores);
    }

    public Integer inputStudentId() {
        Validator idValidator = new IdValidator();
        String studentId = getInputValue();
        return Integer.valueOf(idValidator.validate(studentId));
    }
}
