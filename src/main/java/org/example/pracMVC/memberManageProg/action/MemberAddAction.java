package org.example.pracMVC.memberManageProg.action;

import org.example.pracMVC.memberManageProg.model.Member;
import org.example.pracMVC.memberManageProg.service.MemberAddService;
import org.example.pracMVC.memberManageProg.util.ConsoleUtil;

import java.util.Scanner;

public class MemberAddAction implements Action {

    @Override
    public void execute(Scanner sc) {
        ConsoleUtil cu = new ConsoleUtil();
        Member newMember = cu.getNewMember(sc);

        MemberAddService memberAddService = new MemberAddService();
        boolean isAddSuccess = memberAddService.addMember(newMember);
        if (isAddSuccess) {
            cu.printAddSuccessMessage(newMember);
        } else {
            cu.printAddFailMessage(newMember);
        }
    }
}
