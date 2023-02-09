package com.oops.AbstractandInheritance;

public abstract class Parent {
    int age;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    abstract void res();
    public Parent() {
        System.out.println("Parent constructor");
    }
    public Parent(String name) {
        this.name = name;
    }
    abstract void career();
}
