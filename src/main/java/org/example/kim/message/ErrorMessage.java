package org.example.kim.message;

public enum ErrorMessage {

    BLACK_VALUE("빈 값을 입력하셨습니다."),
    NOT_EXIST_STUDENT_ID("학번이 존재하지 않습니다."),
    INVALID_VALUE("유효하지 않는 값을 입력하셨습니다."),
    INSUFFICIENT_VALUE_COUNT("입력 값이 누락되거나 초과되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
