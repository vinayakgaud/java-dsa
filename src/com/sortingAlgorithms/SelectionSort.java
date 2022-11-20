package com.sortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {20,13,56,-34,0,-1,33,5,7};
        System.out.println("before Sort: "+ Arrays.toString(arr));
        selectionSortAsc(arr);
        System.out.println("after Asc Sort: "+ Arrays.toString(arr));
        selectionSortDesc(arr);
        System.out.println("after Desc Sort: "+ Arrays.toString(arr));
    }
    static void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static void selectionSortAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // find the max item in the remaining array and swap with correct index
//            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, arr.length - i - 1);
            swap(arr, maxIndex, arr.length - i - 1);
        }
    }
    static void selectionSortDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // find the max item in the remaining array and swap with correct index
            int maxIndex = getMaxIndex(arr, i, arr.length-1);
            swap(arr, maxIndex, i);
        }
    }
    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
