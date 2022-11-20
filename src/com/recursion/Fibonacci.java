package com.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibo(50));
    }
    static int fibo(int n){
        if(n < 2) return n; // base condition
        return fibo(n-1) + fibo(n-2); //not efficient because of linear recurrence relation
    }
}
