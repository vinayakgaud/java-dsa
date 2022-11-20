package com.patterns;

public class Patterns {
    public static void main(String[] args) {
        pat31(4);
    }
    static void pat1(int n){
        for (int i = 0; i < 2 * n; i++) {
            int totalCol = i > n ? 2 * n - i : i;
            for (int j = 0; j < totalCol; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pat2(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print(" "+i);
            }
            System.out.println();
        }
    }
    static void pat17(int n){
        for (int i = 1; i <=2 * n ; i++) {
            int totalCol = i > n ? 2 * n - i : i;
            int space = n - totalCol;
            for (int j = 0; j < space; j++) {
                System.out.print("  ");
            }
            for (int j = totalCol; j >=1; j--) {
                System.out.print(" "+j);
            }
            for (int j = 2; j <= totalCol; j++) {
                System.out.print(" "+j);
            }
            System.out.println();
        }
    }
    static void pat17Duplicate(int n){
        for (int i = 1; i <=2 * n ; i++) {
            int totalCol = i > n ? 2 * n - i : i;
            int space = n - totalCol;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = totalCol; j >=1; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= totalCol; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pat28(int n){
        for (int i = 0; i < 2 * n; i++) {
            int totalCol = i > n ? 2 * n - i : i;
            int space = n - totalCol;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < totalCol; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //debug the below one
    static void pat31(int n){
        int orignalN = n;
        n = 2 * n -2;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int col = orignalN - Math.min(Math.min(i,j),Math.min(n - i,n - j));
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
