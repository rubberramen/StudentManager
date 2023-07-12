package org.example.kim.view;

import org.example.kim.dto.ResultDTO;
import org.example.kim.message.FixedMessage;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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

    public void printAll(List<ResultDTO> resultDTOs) {
        AtomicInteger totalSum = new AtomicInteger();
        AtomicReference<Float> totalAvg = new AtomicReference<>(0.0f);

        printTableTop();

        resultDTOs.forEach(resultDTO -> {
            printMessage(resultDTO.makeOutputFormat());
            totalSum.addAndGet(resultDTO.getScore().getTotalScore());
            totalAvg.updateAndGet(v -> v + resultDTO.getScore().getAvgScore());
        });
        printLine();
        printMessage(String.format(TOTAL_SUM_AND_AVG_SCORE.getMessage(),
                totalSum.get(),
                totalAvg.get() / resultDTOs.size()));
        printLine();
    }

    private void printTableTop() {
        printLine();
        printMessage(TABLE_ATTRIBUTE.getMessage());
    }

    public void printStudents(List<ResultDTO> students) {
        printLine();
        printMessage(STUDENT_TABLE_ATTRIBUTE.getMessage());
        students.forEach(resultDTO ->
                printMessage(String.format("%8d%6s", resultDTO.getStudentId(), resultDTO.getStudent().getName())));
        printLine();
    }

    public void printInputId() {
        printMessage(INPUT_STUDENT_ID.getMessage());
    }

    public void printSearchResult(ResultDTO student) {
        printTableTop();
        printMessage(student.makeOutputFormat());
        printLine();
    }
}
