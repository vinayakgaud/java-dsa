package com.sortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {20,13,56,-34,0,-1,33,5,7};
        System.out.println("before Sort: "+ Arrays.toString(arr));
        insertionSortAsc(arr);
        System.out.println("after Asc Sort: "+ Arrays.toString(arr));
        insertionSortDesc(arr);
        System.out.println("after Desc Sort: "+ Arrays.toString(arr));
    }
    static void swap(int[] arr, int firstIndex,int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
    static void insertionSortAsc(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if(arr[j-1] > arr[j]) swap(arr,j-1,j);
                else break;
            }
        }
    }

    static void insertionSortDesc(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if(arr[j-1] < arr[j]) swap(arr,j-1,j);
                else break;
            }
        }
    }
}
