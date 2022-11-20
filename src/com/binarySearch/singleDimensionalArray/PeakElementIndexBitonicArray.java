package com.binarySearch.singleDimensionalArray;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakElementIndexBitonicArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,2,1,0};
        System.out.println(binarySearchResult(arr));
    }
    static int binarySearchResult(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start != end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]){
                end = mid;
            }else if(arr[mid] < arr[mid  +1]){
                start = mid + 1;
            }
        }
        return end;
    }
}

