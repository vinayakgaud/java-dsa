package com.binarySearch.multiDimensionalArray;

import java.util.Arrays;

public class BinarySearchInRowColMatrix {
    public static void main(String[] args) {
//        int[][] arr = {
//                {10,20,30,40},
//                {15,25,35,45},
//                {22,32,42,52},
//                {34,44,54,64}
//        };
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11,12}
        };
        int target = 11;
        System.out.println(Arrays.toString(binarySearch(arr,target)));
    }
//    static int[] binarySearch(int[][] arr, int target){
//        int start = 0;
//        int end = arr[0].length-1;
//        while (start < arr.length && end >= 0){
//            if(arr[start][end] == target) return new int[]{start , end};
//            if(arr[start][end] < target) start++;
//            else end--;
//        }
//        return new int[]{-1,-1};
//    }

    static int[] binarySearch(int[][] arr, int t){
        int s = 0;
        int e = arr[0].length-1;
        while(s < arr.length && e>=0){
            if(arr[s][e] == t) return new int[]{s,e};
            if(arr[s][e] > t) e--;
            else s++;
        }
        return new int[]{-1,-1};
    }
}
