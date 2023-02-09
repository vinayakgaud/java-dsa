package com.strings;

import java.util.ArrayList;

public class longestPalindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("abc"));
        ArrayList<String> res = new ArrayList<>();
        subSeq("","aacabdkacaa",res);
        System.out.println(res);
    }
    public String longestPalindromeM(String s) {
        ArrayList<String> res = new ArrayList<>();
        subSeq("",s,res);
        int maxCount = 0;
        String a = "";
        for(String t:res){
            if(isPalindrome(t)){
                if(t.length() > maxCount){
                    maxCount = t.length();
                    a = t;
                }
            }
        }
        return a;

    }
    public static void subSeq(String p , String up, ArrayList<String> ans){
        if(up.isEmpty()){
            ans.add(p);
            return;
        }
        subSeq(p + up.charAt(0),up.substring(1),ans);
        subSeq(p,up.substring(1),ans);
    }

    public static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        return s.equals(rev);
    }
}
