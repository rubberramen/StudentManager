package org.example.pracMVC.memberManageProg.model;

public class Member {

    private int id;
    private String name;  // 기본키 : 식별값으로 사용.
    private String addr;
    private String nation;
    private String email;
    private int age;

    public Member(String name, String addr, String nation, String email, int age) {
        this.name = name;
        this.addr = addr;
        this.nation = nation;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
