package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] path = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
//        System.out.println(mazeWithObstacles("",0,0, board));
        mazeWithObstaclesPath("",0,0,board,path,1);
    }
    static ArrayList<String> mazeWithObstacles(String p, int row, int col,boolean[][] maze){ //can be solved using backtracking
        if(!maze[row][col]) return new ArrayList<>();
        if(row == maze.length-1 && col == maze[0].length-1) return new ArrayList<>(Collections.singletonList(p));
        ArrayList<String> ans = new ArrayList<>();
        maze[row][col] = false;
        //left
        if(col > 0){
            ans.addAll(mazeWithObstacles(p + "L", row, col-1,maze));
        }
        //up
        if(row > 0){
            ans.addAll(mazeWithObstacles(p + "U", row-1, col,maze));
        }

        //down
        if(row < maze.length-1){
            ans.addAll(mazeWithObstacles(p + "D", row+1, col,maze));
        }

        //right
        if(col < maze[row].length-1){
            ans.addAll(mazeWithObstacles(p + "R", row, col+1,maze));
        }
        //diagonal
        if( row < maze.length-1 && col<maze[row].length-1){
            ans.addAll(mazeWithObstacles(p + "Diag",row+1,col+1,maze));

        }
        maze[row][col] = true;
        return ans;
    }
    static void mazeWithObstaclesPath(String p,int row, int col,boolean[][] maze,int[][] path, int step){ //can be solved using backtracking
        if(!maze[row][col]) return;
        path[row][col] = step;

        if(row == maze.length-1 && col == maze[0].length-1) {
            for (int[] arr:
                 path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        maze[row][col] = false;
        //left
        if(col > 0){
            mazeWithObstaclesPath(p + "L",row, col-1,maze,path,step+1);
        }
        //up
        if(row > 0){
            mazeWithObstaclesPath(p + "U",row-1, col,maze,path,step+1);
        }

        //down
        if(row < maze.length-1){
            mazeWithObstaclesPath(p + "D",row+1, col,maze,path,step+1);
        }

        //right
        if(col < maze[row].length-1){
            mazeWithObstaclesPath(p + "R",row, col+1,maze,path,step+1);
        }
        //diagonal
        if( row < maze.length-1 && col<maze[row].length-1){
            mazeWithObstaclesPath(p + "Diag",row+1,col+1,maze,path,step+1);

        }
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
