package com.recursion.stringsandarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceThrow {
    public static void main(String[] args) {
        System.out.println(dT("",4));
    }
    static ArrayList<String> dT(String p, int up){
        if(up == 0){
            return new ArrayList<>(Arrays.asList(p));
        }
        ArrayList<String> r1 = new ArrayList<>();
        for(int i = 1;i<=up;i++){
            ArrayList<String> r = dT(p + i,up-i);
            r1.addAll(r);
        }
        return r1;
    }
}
