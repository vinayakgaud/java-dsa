package com.recursion;

public class RecursionBasic {
    public static void main(String[] args) {
        print(1);
    }
    static void print(int n){

        if(n == 5){
            System.out.println(n); //base condition
            return;
        }
        System.out.println(n);
        print(n+1); //tail recursion
    }
}
