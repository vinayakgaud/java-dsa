package com.binarySearch.singleDimensionalArray;

import java.util.Arrays;

public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8,9};
        int numberOfRotations = 3;
        System.out.println("Before Rotation: "+Arrays.toString(arr));
        rotatedArray(arr,numberOfRotations);
        System.out.println("After Rotation: "+Arrays.toString(arr));
    }
    static void reverse(int[] a,int i,int j){
        while(i < j){
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }
    static void rotatedArray(int[] arr,int k){
        k = k%arr.length;
        if(k<0) k = k+ arr.length;
        //1stPart
        reverse(arr,0,arr.length-k-1);
        //2ndPart
        reverse(arr,arr.length-k,arr.length-1);
        //all
        reverse(arr,0,arr.length-1);
    }
}
