package com.recursion.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {2,3,5,4,6};
        bubbleSortReverse(a,a.length-1,0);
        System.out.println(Arrays.toString(a));
        bubbleSortAsc(a,a.length-1,0);
        System.out.println(Arrays.toString(a));
    }
    static void bubbleSortReverse(int[] arr, int r, int c){
        if(r == 0) return;
        if(c < r){
            if(arr[c] < arr[c+1]) swap(arr,c,c+1);
            bubbleSortReverse(arr,r,c+1);
        }else{
            bubbleSortReverse(arr,r-1,0);
        }
    }

    static void bubbleSortAsc(int[] arr, int r, int c){
        if(r == 0) return;
        if(c < r){
            if(arr[c] > arr[c+1]) swap(arr,c,c+1);
            bubbleSortAsc(arr,r,c+1);
        }else{
            bubbleSortAsc(arr,r-1,0);
        }
    }
    static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
