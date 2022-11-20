package com.sortingAlgorithms;

public class MissingNumberLeetCode {
    public static void main(String[] args) {
        int[] arr = {0,2,1,3};
        System.out.println(result(arr));
    }
    static int result(int[] arr){
        cyclicSort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i) return i;
        }
        return arr.length;
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while (i<arr.length){
            if(arr[i] != i && arr[i] < arr.length){
                swap(arr,i,arr[i]);
            }else {
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
