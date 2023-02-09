package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        nKnights(board,0,ans);
//        System.out.println(ans);
    }
    private static void nKnights(boolean[][] b, int row, List<List<String>> ans){
        if(row == b.length){
            display(b);
            System.out.println();
            return;
        }
        //iterating through column - i = col
        for (int col = 0; col < b.length; col++) {
            if(isSafe(b,row,col)){
                b[row][col] = true;
                nKnights(b,row+1,ans);
                b[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] b, int row, int col) {
        //checking top left
        if((row > 1 && col > 0) && b[row-2][col-1]){
            return false;
        }

        //checking top right
        if((row > 1 && col < b.length-1) && b[row-2][col+1]){
            return false;
        }

        //checking left
        if((row > 0 && col > 1) && b[row-1][col-2]){
            return false;
        }

        //checking right
        if((row > 0 && col < b.length-2) && b[row-1][col+2]){
            return false;
        }
        return true;
    }

    private static void add(boolean[][] maze, List<List<String>> ans) {

        ArrayList<String> internal = new ArrayList<>();
        for (boolean[] row: maze){
            StringBuilder s = new StringBuilder();
            for(boolean col: row){
                if(col) s.append("K");
                else s.append(".");
            }
            internal.add(s.toString());
        }
        ans.add(internal);
    }

    private static void display(boolean[][] maze) {
        for (boolean[] row: maze){
            for(boolean col: row){
                if(col) System.out.print("K ");
                else System.out.print("N ");
            }
            System.out.println();
        }
    }
}
