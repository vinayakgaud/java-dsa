package com.recursion;

public class Factorial{
    public static void main(String[] args) {
        System.out.println(fact(3));
    }
    static int fact(int n){
        if(n < 2) return 1;
        return n * fact(n-1);
    }
}
