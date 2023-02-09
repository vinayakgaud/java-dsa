package com.recursion;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {0,0,9,0,0,0,6,1,3},
                {0,0,0,0,0,0,2,0,0},
                {0,7,2,5,3,1,0,8,0},
                {3,0,6,0,0,0,0,0,0},
                {1,5,7,0,0,6,8,0,2},
                {2,8,0,7,0,0,1,0,0},
                {0,1,5,9,6,0,0,0,0},
                {0,6,0,1,0,5,4,2,0},
                {9,2,0,3,0,0,5,6,1}
        };
        //[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],
        // [".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],
        // ["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],
        // [".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
        // [".",".",".",".","8",".",".","7","9"]]
        sudokuSolver(board);
        for (int[] row : board){
            for (int col : row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static boolean sudokuSolver(int[][] board){
        boolean empty = true;
        int row = -1;
        int col = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    empty = false;
                    break;
                }
            }
        }
        if(empty) return true;

        for (int i = 1; i <= 9 ; i++) {
            if(isSafe(board,row,col,i)){
                board[row][col] = i;
                if(sudokuSolver(board)){
                    return true;
                }else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board,int row,int col,int num){
        //checking for that row
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == num) return false;
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart+sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }
}
