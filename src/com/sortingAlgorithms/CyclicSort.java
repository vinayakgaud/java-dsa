package com.sortingAlgorithms;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1,5};
        System.out.println("before Sort: "+ Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println("after Asc Sort: "+ Arrays.toString(arr));
//        insertionSortDesc(arr);
//        System.out.println("after Desc Sort: "+ Arrays.toString(arr));
    }
    static void cyclicSort(int[] arr){ //self written
        int i = 0;
        while(i < arr.length){
            if(arr[i] != (i+1)){
                swap(arr,i,(arr[i]-1));
            }else{
                i++;
            }
        }
    }
    //both failing for 3,4,2,1,0 or 2,5,4,6,3
    static void sort(int[] arr) { //kunal's
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int firstIndex,int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
