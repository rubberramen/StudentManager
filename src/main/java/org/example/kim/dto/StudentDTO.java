package org.example.kim.dto;

import java.util.regex.Pattern;

import static org.example.kim.message.ErrorMessage.INVALID_VALUE;

public class StudentDTO {

    private final String name;

    public StudentDTO(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {  // "chan"
        // TODO: 2023-07-11 정규 표현식 활용. 
        String patten = "^[가-힣a-zA-Z]+$";
        if (!Pattern.matches(patten, name)) {
            throw new IllegalArgumentException(INVALID_VALUE.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    //-----------------------

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
