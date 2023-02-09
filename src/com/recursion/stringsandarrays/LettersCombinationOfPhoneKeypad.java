package com.recursion.stringsandarrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LettersCombinationOfPhoneKeypad {
    public static void main(String[] args) {
//        printPerm("","23");
        System.out.println(printPermList("","89"));
//        System.out.println(printPermListLeetCode("","89"));
        System.out.println(printPermListCount("","89"));
    }
    static void printPerm(String p,String up){
        if(up.isEmpty()) {
            System.out.print(p+" ");
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3 ;i <= digit * 3 - 1; i++) {
            if(i != 26){
                char c = (char) ('a' + i);
                printPerm(p + c,up.substring(1));
            }
        }
    }
    static ArrayList<String> printPermList(String p, String up){
        if(up.isEmpty()) {
            return new ArrayList<>(Arrays.asList(p));
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3 ;i <= digit * 3 - 1; i++) {
            if(i != 26){
                char c = (char) ('a' + i);
                ans.addAll(printPermList(p + c,up.substring(1)));
            }
        }
        return ans;
    }
    static int printPermListCount(String p, String up){
        if(up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3 ;i <= digit * 3 - 1; i++) {
            if(i != 26){
                char c = (char) ('a' + i);
                count += printPermListCount(p + c,up.substring(1));
            }
        }
        return count;
    }

    static ArrayList<String> printPermListLeetCode(String p, String up){
        if(up.isEmpty()) {
            return new ArrayList<>(Arrays.asList(p));
        }
        int digit = up.charAt(0) - '0';
        int s = (digit - 2) * 3;
        int len = s + 2;
        if(digit > 7){
            s += 1;
        }
        if(digit == 7 || digit == 9){
            len = s+3;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i =  s;i <= len; i++) {
            if(i != 26){
                char c = (char) ('a' + i);
                ans.addAll(printPermListLeetCode(p + c,up.substring(1)));
            }
        }
        return ans;
    }
}
