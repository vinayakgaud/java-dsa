package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        nQueens(board,0,ans);
        System.out.println(ans);
    }
    private static void nQueens(boolean[][] b, int row,List<List<String>> ans){
        if(row == b.length){
            display(b);
            System.out.println();
            return;
        }
        //iterating through column - i = col
        for (int col = 0; col < b.length; col++) {
            if(isSafe(b,row,col)){
                b[row][col] = true;
                nQueens(b,row+1,ans);
                b[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] b, int row, int col) {
        //checking vertically
        for (int i = 0; i < row; i++) {
            if(b[i][col]){
                return false;
            }
        }

        //checking left diagonally
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft ; i++) {
            if(b[row-i][col-i]){
                return false;
            }
        }
        //checking right diagonally
        int maxRight = Math.min(row,b.length - col - 1);
        for (int i = 1; i <= maxRight ; i++) {
            if(b[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static void add(boolean[][] maze, List<List<String>> ans) {

        ArrayList<String> internal = new ArrayList<>();
        for (boolean[] row: maze){
            StringBuilder s = new StringBuilder();
            for(boolean col: row){
                if(col) s.append("Q");
                else s.append(".");
            }
            internal.add(s.toString());
        }
        ans.add(internal);
    }
    private static void display(boolean[][] maze) {
        for (boolean[] row: maze){
            for(boolean col: row){
                if(col) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }
}
