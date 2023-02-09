package com.binarySearch.singleDimensionalArray;

public class CountRotationOfArray {
    //Rotated sorted array
    public static void main(String[] args) {
        int[] arr = {10,20,30,5,10,50};
//        System.out.println(countOfRotation(arr));
        System.out.println(countOfRotationBS(arr));
    }
    //using linear search O(n)
    static int countOfRotation(int[] arr){
        int count = 1;
        int i = 0;
        while(arr[i] < arr[i+1]){
            count++;
            i++;
        }
        return count;
    }

    //using binary search
    static int countOfRotationBS(int[] arr){
        return findPivot(arr) + 1;
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid+1]) return mid;
            if(mid > start && arr[mid-1] > arr[mid]) return mid-1;
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
