package com.oops.AbstractandInheritance;

public class Child extends Parent{
    public Child(String name, int age) {
        System.out.println("child");
        this.age = age;
        this.setName(name);
    }
    @Override
    void res() {

    }
    @Override
    void career(){
        System.out.println("My age is "+this.age + " name is "+ getName());
    }

    public Child(Child child){
        this.age = child.age;
        this.setName(child.getName());
    }
}
