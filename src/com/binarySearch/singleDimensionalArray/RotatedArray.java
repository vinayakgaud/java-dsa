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
    static int[] rotatedArray(int[] arr,int k){
        for (int i = 0; i < k; i++) {
            int temp = arr[arr.length-1];
            arr[arr.length-1-i] = arr[arr.length-2 - i];
            arr[0] = temp;
        }
        return arr;
    }
}
