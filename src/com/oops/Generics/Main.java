package com.oops.Generics;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomArrayListWithGenerics<String> a = new CustomArrayListWithGenerics<>();
        a.add("10");
        a.add("20");
        System.out.println(a);
        a.set(1,"30");
        System.out.println(a);
//        System.out.println("Index for element 30: "+a.getIndex("30"));
//        System.out.println("Element at index 1 : "+a.get(1));
        a.remove("10");
        System.out.println(a);
        a.remove("40");
        System.out.println(a);
        a.remove("30");
//        System.out.println("Size of List: "+a.sizeOfList());
    }
}
