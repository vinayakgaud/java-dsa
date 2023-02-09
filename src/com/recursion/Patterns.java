package com.recursion;

public class Patterns {
    public static void main(String[] args) {
        int n = 4;
        printPattern(n);
    }
    static void printPattern(int n){
        helper(n,n,0);
    }
    static void helper(int n, int row, int col){
        if(row <= 0) return;
        if(col < row){
            System.out.print("*");
            helper(n,row,col+1);
        }
        col = 0;
        System.out.println();
        helper(n,row-1,col);
    }
}
