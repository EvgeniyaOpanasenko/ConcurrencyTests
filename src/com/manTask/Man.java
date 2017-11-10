package com.manTask;

/**
 * Created by User on 11/10/2017.
 */
public class Man {
    private String name;
    private int age;
    private boolean brother;

    public Man(String name, int age, boolean brother) {
        this.name = name;
        this.age = age;
        this.brother = brother;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBrother() {
        return brother;
    }

    public void setBrother(boolean brother) {
        this.brother = brother;
    }

    public boolean isGork() {
        if (this.isBrother()){
            return true;
        }
        return false;
    }


    public void happy() {
        System.out.println("Happy life with a woman who loves");
    }

    public void happy(Woman woman) {
        System.out.println("happy with loving wife my own family and kids");
    }
}
