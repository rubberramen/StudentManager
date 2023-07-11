package org.example.kim.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDTOTest {

    @Test
    void test01() {
//        System.out.println("Hello World");

        String[] scores = {"80", "60", "90"};
        ScoreDTO scoreDTO = new ScoreDTO(scores);

        System.out.println("hello");
    }

}