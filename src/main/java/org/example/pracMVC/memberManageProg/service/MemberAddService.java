package org.example.pracMVC.memberManageProg.service;

import org.example.pracMVC.memberManageProg.dao.MemberDAO;
import org.example.pracMVC.memberManageProg.model.Member;

public class MemberAddService {

    public boolean addMember(Member newMember) {
        boolean isInsertSuccess = false;
        MemberDAO dao = new MemberDAO();

        dao.insert(newMember);

        if (dao.getMemberList().size() > 0) {
            isInsertSuccess = true;
        }

        return isInsertSuccess;
    }
}
