package org.example.pracMVC.memberManageProg.controller;

import org.example.pracMVC.memberManageProg.action.Action;

import java.util.Scanner;

public class MemberController {
    public void processRequest(Action action, Scanner sc) {
        action.execute(sc);
    }
}
