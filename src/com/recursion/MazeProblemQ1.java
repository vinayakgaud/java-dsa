package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MazeProblemQ1 {
    public static void main(String[] args) {
        count("",1,1);
        System.out.println();
        System.out.println(countA("",1,1));
    }
    static void count(String p, int i, int j){
        if(i == 3 && j == 3) {
            System.out.print(p+" ");
            return;
        }
        //going right
        if(j < 3){
            count(p + "R",i,j+1);
        }
        //going down
        if(i < 3){
            count(p + "D",i+1,j);
        }
        if( i < 3 && j<3){
            count(p + "Diag",i+1,j+1);
        }
    }
    static ArrayList<String> countA(String p, int i, int j){
        if(i == 3 && j == 3) {
            return new ArrayList<>(Collections.singleton(p));
        }
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        //going right
        if(j < 3){
            left = countA(p + "R",i,j+1);
        }
        //going down
        if(i < 3){
            right = countA(p + "D",i+1,j);
        }
        ArrayList<String> diag = new ArrayList<>();
        if( i < 3 && j<3){
           diag = countA(p + "Diag",i+1,j+1);
        }
        left.addAll(right);
        left.addAll(diag);
        return left;
    }
}
