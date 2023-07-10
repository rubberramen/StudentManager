package org.example.pracMVC.memberManageProg.util;

import org.example.pracMVC.memberManageProg.model.Member;

import java.util.Scanner;

public class ConsoleUtil {
    public Member getNewMember(Scanner sc) {
        System.out.println("등록할 회원정보를 입력하세요");
        System.out.print("이름 = ");
        String name = sc.next();

        System.out.print("주소 = ");
        String addr = sc.next();

        System.out.print("이메일 = ");
        String email = sc.next();

        System.out.print("국가 = ");
        String nation = sc.next();

        System.out.print("나이 = ");
        int age = sc.nextInt();

        return new Member(name, addr, nation, email, age);
    }

    // 1-2. 회원정보등록 성공 메세지
    public void printAddSuccessMessage(Member newMember) {
        System.out.println(newMember.getName() + "님 회원정보등록이 성공하였습니다.");

    }
    // 1-3. 회원정보등록 실패 메세지
    public void printAddFailMessage(Member newMember) {
        System.out.println(newMember.getName() + "님 회원정보등록이 실패하였습니다.");
    }

    public String getName(String msg, Scanner sc) {   // msg = 수정 or 삭제
        System.out.println(msg + "할 회원의 이름을 입력하세요");
        System.out.print("이름 = ");
//		String name = sc.nextLine();
//		return name;  두줄을 아래 한줄로....
        return sc.nextLine();
    }

    public Member getUpdateMember(Scanner sc, Member oldMember) {
        System.out.println("수정할 회원의 정보를 입력하세요");
        System.out.println("이전국가 : " + oldMember.getNation());
        System.out.print("수정국가 = ");
        String nation = sc.nextLine();

        System.out.print("이전주소 : " + oldMember.getAddr());
        System.out.print("수정주소 = ");
        String addr = sc.nextLine();

        System.out.print("이전메일 : " + oldMember.getEmail());
        System.out.print("수정메일 = ");
        String email = sc.nextLine();

        System.out.print("이전나이 : " + oldMember.getAge());
        System.out.print("수정나이 = ");
        int age = sc.nextInt();

//		Member mem = new Member(oldMember.getName(), addr, nation, email, age);
//		return mem;  // 두 줄 하나로
        return new Member(oldMember.getName(), addr, nation, email, age);
    }

    public void printModifySuccessMessage(Member updateMember) {
        System.out.println(updateMember.getName() + "님 회원정보수정이 성공하였습니다.");
    }

    public void printModifyFailMessage(Member updateMember) {   // 정보 수정 실패 메시지
        System.out.println(updateMember.getName() + "님 회원정보수정이 실패하였습니다.");
    }
}
