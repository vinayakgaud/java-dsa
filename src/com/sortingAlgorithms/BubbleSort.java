package com.sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {20,13,56,-34,0,-1,33,5,7};
        System.out.println("before Sort: "+ Arrays.toString(arr));
        bubbleSortAsc(arr);
        System.out.println("after Asc Sort: "+ Arrays.toString(arr));
        bubbleSortDesc(arr);
        System.out.println("after Desc Sort: "+ Arrays.toString(arr));
    }
    static void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static void bubbleSortAsc(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                    swapped = true;
                }
            }
            if(!swapped) break; //breaking if no swap occurred to not run the program again and again without any reason
        }
    }
    static void bubbleSortDesc(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] < arr[j]){
                    swap(arr,j-1,j);
                    swapped = true;
                }
            }
            if(!swapped) break; //breaking if no swap occurred to not run the program again and again without any reason
        }
    }
}
