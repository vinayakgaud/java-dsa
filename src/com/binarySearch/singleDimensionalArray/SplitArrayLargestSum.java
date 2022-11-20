package com.binarySearch.singleDimensionalArray;

public class SplitArrayLargestSum {
    //https://leetcode.com/problems/split-array-largest-sum/description/
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(ans(arr,2));
    }
    static int ans(int[] arr, int maxSubArrays){
        int start = maxElementOfArray(arr);
        int end = maxSumOfArray(arr);
        return binarySearch(arr,start,end,maxSubArrays);
    }
    static int maxSumOfArray(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    static int maxElementOfArray(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    static int binarySearch(int[] arr,int start,int end, int m){
        while (start < end){
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            for (int num: arr) {
                if(sum + num > mid){
                    pieces++;
                    sum = num;
                }else{
                    sum += num;
                }
            }
            if(pieces>m){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
