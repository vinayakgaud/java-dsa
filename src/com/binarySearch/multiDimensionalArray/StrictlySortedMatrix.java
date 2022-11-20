package com.binarySearch.multiDimensionalArray;

import java.util.Arrays;

public class StrictlySortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11,12}
        };
        int target = 11;
        System.out.println(Arrays.toString(resultOfSearch(arr,target)));
    }

    static int[] resultOfSearch(int[][] arr, int target){
        int rowLength = arr.length;
        int colLength = arr[0].length;
        if (colLength == 0){
            return new int[] {-1,-1};
        }
        if (rowLength == 1) {
            return binarySearch(arr,target, 0, 0, colLength-1);
        }
        int rowStart = 0;
        int rowEnd = rowLength-1;
        int colMid = colLength/2;
        while(rowStart < (rowEnd-1)){
            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            if(arr[rowStart][rowMid] == target) return new int[]{rowStart,rowMid};
            if(arr[rowStart][rowMid]< target){
                rowStart = rowMid;
            }else{
                rowEnd = rowMid;
            }
        }

        if (arr[rowStart][colMid] == target) {
            return new int[]{rowStart, colMid};
        }
        if (arr[rowStart + 1][colMid] == target) {
            return new int[]{rowStart + 1, colMid};
        }

        if(target <= arr[rowStart][colMid - 1]) return binarySearch(arr,target,rowStart,0,colMid-1);
        if(target >= arr[rowStart][colMid + 1] && target <= arr[rowStart][colLength-1]) return binarySearch(arr,target,rowStart,colMid+1,colLength-1);
        if(target <= arr[rowStart + 1][colMid-1]){
            return binarySearch(arr,target,rowStart+1,0,colMid-1);
        }else{
            return binarySearch(arr,target,rowStart+1,colMid+1,colLength-1);
        }
    }

    static int[] binarySearch(int[][] arr, int target, int row, int colStart, int colEnd){
        while(colStart <= colEnd){
            int mid = colStart + (colEnd - colStart) / 2;
            if(arr[row][mid] == target) return new int[] {row,mid};
            if(arr[row][mid] < target){
                colEnd = mid - 1;
            }else{
                colStart = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}
