package com.recursion;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,13,12,14,15,16,167,177,144,1566,1555};
        int target = 16;
        System.out.println(search(arr,target,0,arr.length-1));
    }
    static int search(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == target) return mid;
        if(arr[mid] < target){
            return search(arr,target,mid + 1,end);
        }
        return search(arr,target,start,mid - 1);
    }
}
