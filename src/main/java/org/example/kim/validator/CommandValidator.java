package org.example.kim.validator;

import org.example.kim.command.Command;

import java.util.Arrays;

import static org.example.kim.message.ErrorMessage.BLACK_VALUE;
import static org.example.kim.message.ErrorMessage.INVALID_VALUE;

public class CommandValidator implements Validator{

    @Override
    public String validate(String inputValue) {
        checkBlankValue(inputValue);
        checkInvalidCommand(inputValue);
        return inputValue;
    }

    private void checkInvalidCommand(String inputValue) {
        if (!isValidCommand(inputValue)) {
            throw new IllegalArgumentException(INVALID_VALUE.getMessage());
        }
    }

    private boolean isValidCommand(String inputValue) {
        return Arrays.stream(Command.values())
                .anyMatch(command -> command.equalCommand(inputValue));
    }

    private void checkBlankValue(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException(BLACK_VALUE.getMessage());
        }
    }
}
