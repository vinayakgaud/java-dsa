package com.binarySearch.singleDimensionalArray;

public class InfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,8,9,10};
        int target = 5;
        System.out.println(result(arr,target));
    }

    static int result(int[] arr, int target){
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr,target, start,end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(target < arr[(int)mid]){
                end = (int) mid - 1;
            }else if(target > arr[(int)mid]){
                start = (int) mid + 1;
            }else{
                return (int)mid;
            }
        }
        return -1;
    }
}