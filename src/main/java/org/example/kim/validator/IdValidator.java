package org.example.kim.validator;

import java.util.regex.Pattern;

import static org.example.kim.message.ErrorMessage.INVALID_VALUE;

public class IdValidator implements Validator {

    @Override
    public String validate(String inputValue) {
        checkReg(inputValue);
        checkInvalidStudentIdLength(inputValue);
        return inputValue;
    }

    private void checkInvalidStudentIdLength(String inputValue) {
        int studentIdLength = 8;
        if (inputValue.length() != studentIdLength) {
            throw new IllegalArgumentException(INVALID_VALUE.getMessage());
        }
    }

    private void checkReg(String inputValue) {
        // TODO: 2023-07-13 013 정규 표현식 체크.
        String patten = "^\\d+$";
        if (!Pattern.matches(patten, inputValue)) {
            throw new IllegalArgumentException(INVALID_VALUE.getMessage());
        }
    }


}
