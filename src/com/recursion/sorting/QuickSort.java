package com.recursion.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,6,8,1,7};
        sortAsc(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        sortAsDesc(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sortAsc(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s+(e-s)/2;
        int pivot = arr[m];
        while(s <= e){
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }

            if(s<=e){
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++;
                e--;
            }
        }
        sortAsc(arr,low,e);
        sortAsc(arr,s,high);
    }

    static void sortAsDesc(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s+(e-s)/2;
        int pivot = arr[m];
        while(s <= e){
            while(arr[s] > pivot){
                s++;
            }
            while(arr[e] < pivot){
                e--;
            }

            if(s<=e){
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++;
                e--;
            }
        }
        sortAsDesc(arr,low,e);
        sortAsDesc(arr,s,high);
    }
}
