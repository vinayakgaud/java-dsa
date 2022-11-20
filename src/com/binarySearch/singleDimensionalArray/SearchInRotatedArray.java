package com.binarySearch.singleDimensionalArray;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(targetInRotatedSortedArray(arr,target));
    }
    static int targetInRotatedSortedArray(int[] arr, int target){
        int pivot = findPivotWithDuplicates(arr);
        if(pivot == -1 ) return binarySearch(arr,target,0,arr.length-1);
        if(arr[pivot] == target) return pivot;
        if(arr[0] <= target) return binarySearch(arr,target,0,pivot-1);
        return binarySearch(arr,target,pivot+1,arr.length-1);
    }
    static int peakElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid+1]) return mid;
            if(mid > start && arr[mid] < arr[mid-1]) return mid-1;
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid+1]) return mid;
            if(mid > start && arr[mid] < arr[mid-1]) return mid-1;
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(start < end && arr[start] > arr[start+1]){
                    return start;
                }
                start++;
                if( start < end && arr[end-1] > arr[end]){
                    return end-1;
                }
                end--;
            }else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]) ){
                start = mid +1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end =  mid - 1;
            }else if(target > arr[mid]){
                start =  mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
