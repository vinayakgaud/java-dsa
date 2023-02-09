package com.binarySearch.singleDimensionalArray;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PeakElementFindTarget {
    public static void main(String[] args) {
        int[] arr = {0,2,3,1};
        int target = 1;
//        System.out.println(result(arr,target));
        System.out.println(peakElementIndex(arr));
    }

    static int result(int[] arr, int target){
        int peakIndex = peakElementIndex(arr);
        int firstLoop = orderAgnosticBinarySearch(arr,target,0,peakIndex);
        if(firstLoop != -1) return firstLoop;
        return orderAgnosticBinarySearch(arr,target,peakIndex+1, arr.length-1);
    }

    static int peakElementIndex(int[] arr){
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
    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            if(isAsc){
                if(target<arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target>arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
