package com;

import java.util.ArrayList;
import java.util.Arrays;

public class permutation {
        public static void main(String[] args) {
            System.out.println(permutationOfString("","abc"));
        }
        public static boolean checkInclusion(String s1, String s2) {
            if(s1.length() > s2.length()) return false;
            ArrayList<Character> s2s = new ArrayList<>();
            for(char c : s2.toCharArray()){
                s2s.add(c);
            }
            for(int i = 0;i<s1.length();i++){
                if(!s2s.contains(s1.charAt(i))) return false;
            }
            ArrayList<String> perm = permutationOfString("",s1);
            System.out.println(perm);
            for(String s : perm){
                if(s2.contains(s)) return true;
            }
            return false;
        }
        static ArrayList<String> permutationOfString(String proc, String unproc){
            if(unproc.isEmpty()){
                return new ArrayList<String>(Arrays.asList(proc));
            }

            char c = unproc.charAt(0);
            ArrayList<String> res = new ArrayList<>();
            for(int i = 0;i<=proc.length();i++){
                String first = proc.substring(0,i);
                String second = proc.substring(i);
                res.addAll(permutationOfString(first+c+second,unproc.substring(1)));
            }
            return res;
        }
}
