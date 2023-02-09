package com.recursion.stringsandarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class permutations {
    public static void main(String[] args) {
//        permutation("","abc");
//        System.out.println(permutationL("","abc"));
        int[] arr = {1,2,3};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        int n = Integer.parseInt(s.toString());
        System.out.println(n);
        ArrayList<String> res = helper(arr);
        System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            if(Integer.parseInt(res.get(i)) > n) System.out.println(res.get(i));
        }
    }
    static ArrayList<String> helper(int[] arr){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        return permutationL("",s.toString());
    }
    static void permutation(String proc, String unproc){
        if(unproc.isEmpty()){
            System.out.print(proc+" ");
            return;
        }
        for (int i = 0; i <= proc.length(); i++) {
            String first = proc.substring(0,i);
            String second = proc.substring(i);
            permutation(first + unproc.charAt(0) + second,unproc.substring(1));
        }
    }
    static ArrayList<String> permutationL(String proc, String unproc) {
        if (unproc.isEmpty()) {
            return new ArrayList<>(Collections.singletonList(proc));
        }

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i <= proc.length(); i++) {
            String first = proc.substring(0, i);
            String second = proc.substring(i);
            ArrayList<String> l = permutationL(first + unproc.charAt(0) + second, unproc.substring(1));
            res.addAll(l);
        }
        return res;
    }

}
