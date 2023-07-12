package org.example.kim.controller;

import org.example.kim.command.Command;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentScoreManagementControllerTest {

    @Test
    void test() {
        Command[] values = Command.values();
        System.out.println(Arrays.toString(values));
    }

}