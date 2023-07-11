package org.example.kim.command;

import java.util.Objects;

public enum Command {
    ADD_STUDENT_AND_SCORE("1", "학생 정보 및 성적 추가"),
    SEARCH("2", "학생 성적 검색"),
    STUDENT_SCORE_LIST("3", "전체 학생 성적 출력"),
    MODIFY_SCORE("4", "성적 수정"),
    DELETE_SCORE("5", "학생 정보 및 성적 제거"),
    EXIT("0", "시스템 종료");

    private final String commandNum;
    private final String commandName;

    Command(String commandNum, String commandName) {
        this.commandNum = commandNum;
        this.commandName = commandName;
    }

    public String getCommandNum() {
        return commandNum;
    }

    public String getCommandName() {
        return commandName;
    }

    public boolean equalCommand(String commandNum) {
        return Objects.equals(this.commandNum, commandNum);
    }
}
