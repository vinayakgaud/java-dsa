package com.recursion.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3,4,6,7,5,2,1};
//        System.out.println(Arrays.toString(mergeSortNotInPlaceArrayAsc(a)));
//        System.out.println(Arrays.toString(mergeSortNotInPlaceArrayDesc(a)));
        mergeSortInPlaceArrayDesc(a,0,a.length);
        System.out.println(Arrays.toString(a));
        mergeSortInPlaceArrayAsc(a,0,a.length);
        System.out.println(Arrays.toString(a));
    }
    static int[] mergeSortNotInPlaceArrayDesc(int[] arr){
        if(arr.length == 1) return arr;
        int m = arr.length / 2;
        int[] leftArr = mergeSortNotInPlaceArrayDesc(Arrays.copyOfRange(arr,0,m));
        int[] rightArr = mergeSortNotInPlaceArrayDesc(Arrays.copyOfRange(arr,m,arr.length));
        return mergeDesc(leftArr,rightArr);
    }

    static int[] mergeDesc(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArr.length && j < rightArr.length){
            if(leftArr[i] > rightArr[j]){
                result[k] = leftArr[i];
                i++;
            }else{
                result[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length){
            result[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArr.length){
            result[k] = rightArr[j];
            j++;
            k++;
        }

        return result;
    }
    static int[] mergeSortNotInPlaceArrayAsc(int[] arr){
        if(arr.length == 1) return arr;
        int m = arr.length / 2;
        int[] leftArr = mergeSortNotInPlaceArrayAsc(Arrays.copyOfRange(arr,0,m));
        int[] rightArr = mergeSortNotInPlaceArrayAsc(Arrays.copyOfRange(arr,m,arr.length));
        return mergeAsc(leftArr,rightArr);
    }

    static int[] mergeAsc(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArr.length && j < rightArr.length){
            if(leftArr[i] < rightArr[j]){
                result[k] = leftArr[i];
                i++;
            }else{
                result[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length){
            result[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArr.length){
            result[k] = rightArr[j];
            j++;
            k++;
        }

        return result;
    }

    static void mergeSortInPlaceArrayDesc(int[] arr,int s,int e){
        if(e - s == 1) return;
        int m = s + (e-s) / 2;
        mergeSortInPlaceArrayDesc(arr,s,m);
        mergeSortInPlaceArrayDesc(arr,m,e);
        mergeDescIn(arr,s,m,e);
    }

    static void mergeDescIn(int[] arr, int s, int m,int e) {
        int[] result = new int[e-s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e){
            if(arr[i] > arr[j]){
                result[k] = arr[i];
                i++;
            }else{
                result[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < m){
            result[k] = arr[i];
            i++;
            k++;
        }
        while (j < e){
            result[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < result.length; l++) {
            arr[s+l] = result[l];
        }

    }
    static void mergeSortInPlaceArrayAsc(int[] arr,int s,int e){
        if(e - s == 1) return;
        int m = s + (e-s) / 2;
        mergeSortInPlaceArrayAsc(arr,s,m);
        mergeSortInPlaceArrayAsc(arr,m,e);
        mergeAscIn(arr,s,m,e);
    }

    static void mergeAscIn(int[] arr, int s, int m,int e) {
        int[] result = new int[e-s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e){
            if(arr[i] < arr[j]){
                result[k] = arr[i];
                i++;
            }else{
                result[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < m){
            result[k] = arr[i];
            i++;
            k++;
        }
        while (j < e){
            result[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < result.length; l++) {
            arr[s+l] = result[l];
        }

    }
}
