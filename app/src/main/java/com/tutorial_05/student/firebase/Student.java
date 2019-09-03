package com.tutorial_05.student.firebase;

public class Student {

    private String ID;
    private String Name;
    private String Address;
    private Integer ConNum;

    public Student() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getConNum() {
        return ConNum;
    }

    public void setConNum(Integer conNum) {
        ConNum = conNum;
    }


}
