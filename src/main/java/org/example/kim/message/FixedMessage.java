package org.example.kim.message;

import static org.example.kim.command.Command.*;

public enum FixedMessage {

    TITLE("학생성적관리 프로그램"),
    MENU(ADD_STUDENT_AND_SCORE.getCommandNum() + ": " + ADD_STUDENT_AND_SCORE.getCommandName() + "\n" +
            SEARCH.getCommandNum() + ": " + SEARCH.getCommandName() + "\n" +
            STUDENT_SCORE_LIST.getCommandNum() + ": " + STUDENT_SCORE_LIST.getCommandName() + "\n" +
            MODIFY_SCORE.getCommandNum() + ": " + MODIFY_SCORE.getCommandName() + "\n" +
            DELETE_SCORE.getCommandNum() + ": " + DELETE_SCORE.getCommandName() + "\n" +
            EXIT.getCommandNum() + ": " + EXIT.getCommandName() + "\n"),
    COMMAND_NUM("원하는 작업의 번호를 입력해주세요."),
    INPUT_STUDENT_DATA_GUIDE("이름을 입력해주세요."),
    INPUT_SCORE_GUIDE("성적을 입력해주세요. \n " +
            "입력 순서는 [국어성적 영어성적 수학성적] 입니다. \n" +
            "(예:100 100 100) \n" +
            "!주의 : 공백 이외의 구분은 하지 않습니다."),
    STUDENT_TABLE_ATTRIBUTE(String.format("%6s%6s", "학번", "이름")),
    TABLE_ATTRIBUTE(String.format("%6s%6s%8s%6s%6s%4s%6s", "학번", "이름", "국어점수", "영어점수", "수학점수", "총합", "평균")),
    INPUT_STUDENT_ID("학생의 학번을 입력해주세요."),
    TOTAL_SUM_AND_AVG_SCORE("총점 : %d \n평균 : %.1f"),
    LINE("=========================================================");

    private final String message;

    FixedMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
