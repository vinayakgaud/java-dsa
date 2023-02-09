package com.oops.AbstractandInheritance;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.size();
        System.out.println(a);
        Child c = new Child("Vin",3);
        c.career();
//        Parent r = new Parent(){
//            @Override
//            void res() {
//                System.out.println("Res");
//            }
//            @Override
//            void career() {
//                System.out.println("Car");
//            }
//        };
//        r.career();
//        r.res();

        Child c1 = new Child(new Child("HH",2));
        c1.career();
    }
}
