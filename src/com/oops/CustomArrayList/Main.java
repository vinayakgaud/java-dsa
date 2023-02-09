package com.oops.CustomArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomArrayList a = new CustomArrayList();
        a.add(10);
        a.add(20);
        System.out.println(a);
        a.set(1,30);
        System.out.println(a);
//        System.out.println(a.getIndex(30));
//        System.out.println(a.get(1));
        a.remove(10);
        System.out.println(a);
        a.remove(30);
        System.out.println(a);
        a.remove(30);
//        System.out.println(a.sizeOfArray());
    }
}
