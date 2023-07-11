package org.example.kim.dto;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class StudentDTOTest {

    @Test
    void test() {
        try {
            StudentDTO studentDTO = new StudentDTO("chan wang");
            System.out.println("studentDTO = " + studentDTO);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test01() {
        String regex = "^[a-zA-Z]+$"; // 띄어쓰기도 처리.
        String input = "TestStrig";

        System.out.println(Pattern.matches(regex, input)); // false???

//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//
//        System.out.println(matcher.matches());// false
    }






}