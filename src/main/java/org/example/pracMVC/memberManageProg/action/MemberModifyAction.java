package org.example.pracMVC.memberManageProg.action;

import org.example.pracMVC.memberManageProg.model.Member;
import org.example.pracMVC.memberManageProg.service.MemberModifyService;
import org.example.pracMVC.memberManageProg.util.ConsoleUtil;

import java.util.Scanner;

public class MemberModifyAction implements Action {

    @Override
    public void execute(Scanner sc) {
        ConsoleUtil cu = new ConsoleUtil();

        String name = cu.getName("수정", sc);
        MemberModifyService memberModifyService = new MemberModifyService();
        Member oldMember = memberModifyService.getOldMember(name);

        Member updateMember = cu.getUpdateMember(sc, oldMember);

        boolean isModifySuccess = memberModifyService.modifyMember(updateMember);

        if (isModifySuccess) {
            cu.printModifySuccessMessage(updateMember);
        } else {
            cu.printModifyFailMessage(updateMember);
        }
    }
}
