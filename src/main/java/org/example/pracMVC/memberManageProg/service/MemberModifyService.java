package org.example.pracMVC.memberManageProg.service;

import org.example.pracMVC.memberManageProg.dao.MemberDAO;
import org.example.pracMVC.memberManageProg.model.Member;

public class MemberModifyService {

    public Member getOldMember(String name) {
        Member oldMember = null;

        MemberDAO dao = new MemberDAO();
        oldMember = dao.getSelectMember(name);

        return oldMember;
    }

    public boolean modifyMember(Member updateMember) {
        boolean isModifySuccess = false;

        MemberDAO dao = new MemberDAO();
        isModifySuccess = dao.update(updateMember);


        return isModifySuccess;
    }
}
