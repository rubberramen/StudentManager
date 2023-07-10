package org.example.pracMVC.memberManageProg;

import org.example.pracMVC.memberManageProg.action.Action;
import org.example.pracMVC.memberManageProg.action.MemberAddAction;
import org.example.pracMVC.memberManageProg.action.MemberListAction;
import org.example.pracMVC.memberManageProg.action.MemberModifyAction;
import org.example.pracMVC.memberManageProg.controller.MemberController;

import java.util.Scanner;

public class MemberManageApp {

    public static void main(String[] args) {

        MemberController memberController = new MemberController();

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================================");
        System.out.println("                       <🏫 멤버 관리 프로그램>                       ");
        System.out.println("==================================================================");

        while (true) {
            // 메뉴 안내
            System.out.println();
            System.out.println("* 메뉴를 선택하세요(🚩반드시 정수 입력. 정수 입력 안하면 울꼬얌😢)");   // 정수 외 입력 받았을 때 방어 로직 필요
            System.out.println("==================================================================");
            System.out.println("1 : 회원 등록 / 2 : 회원 목록 / 0 : 😛프로그램 종료");

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            Action action = null;

            switch (menu) {
                case 1:
                    action = new MemberAddAction();
                    break;
                case 2:
                    action = new MemberListAction();
                    break;
                case 3:
                    action = new MemberModifyAction();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("== 🪓메뉴 선택 오류 : 응 다시 선택해~  ==");
            }

            if (action != null) {
                memberController.processRequest(action, sc);
            }
        }
    }
}
