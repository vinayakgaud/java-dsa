package com.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {2,1,3,4,6};
        selectionSortAsc(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        selectionSortDesc(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    static void selectionSortAsc(int[] arr, int s, int e){
        if(e == 0) return;
        int max = getMaxIndex(arr,s,e);
        swap(arr,max,e);
        selectionSortAsc(arr,s,e-1);
    }
    static void selectionSortDesc(int[] arr, int s, int e){
        if(s > e) return;
        int max = getMaxIndex(arr,s,e);
        swap(arr,s,max);
        selectionSortDesc(arr,s+1,e);
    }
    static int getMaxIndex(int[] arr, int s,int e){
        int max = s;
        for (int i = s; i <= e; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
