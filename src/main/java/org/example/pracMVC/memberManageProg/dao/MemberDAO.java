package org.example.pracMVC.memberManageProg.dao;

import org.example.pracMVC.memberManageProg.model.Member;

import java.util.ArrayList;

public class MemberDAO {

    static ArrayList<Member> memberList = new ArrayList<Member>();

    public void insert(Member newMember) {
        memberList.add(newMember);
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public int getMemberCounter() {
        return memberList.size();   // 몇명의 회원이 등록되어 있는지 알 수 있다.
    }

    public Member getSelectMember(String name) {
        Member oldMember = null;

        // 회원에 대한 정보를 가지고 있는 컬렉션 객체를 비교해서
        //이름과 일치하는 객체를 찾는 작업
        for(int i = 0 ; i < memberList.size() ; i++) {
            //컬렉션에 객체 하나를 저장할 임시변수
            Member mem = memberList.get(i);

            if(name.equals(mem.getName())) {  // 입력받은 이름과 일치하는 회원이 존재할 때.
                oldMember = new Member(name, mem.getAddr(), mem.getNation(),
                        mem.getEmail(), mem.getAge());
            }
        }
        return oldMember;
    }

    public boolean update(Member updateMember) {
        boolean isUpdateSuccess = false;

        for(int i = 0 ; i < memberList.size() ; i++) {
            Member mem = memberList.get(i);

            // 똑같은 이름을 가진 객체를 하나 더 만들어 내는 것이 아니라.
            // 기존의 객체를 새로운 객체로 변경하는 작업이다. 지우고 생성
            if(updateMember.getName().equals(mem.getName())); {
                // 같은 이름을 가지고 있는 객체를 찾았다면,

                // 지우고 생성하는 방법
                memberList.remove(i);
                // 새롭게 수정된 객체를 컬렉션에 담는 작업.
                memberList.add(updateMember);

                // 업데이트하는 방법
//				mem.setAddr(updateMember.getAddr());
//				mem.setEmail(updateMember.getEmail());
//				mem.setNation(updateMember.getNation());
//				mem.setAge(updateMember.getAge());

                isUpdateSuccess = true;
            }
        }
        return isUpdateSuccess;
    }
}
