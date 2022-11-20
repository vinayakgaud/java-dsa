package com.binarySearch.singleDimensionalArray;

import java.util.Arrays;

//binary search in infinite array
public class StarProj {
    public static void main(String[] args) {
//        char[] arr = {'c','f','j'};
//        char target = 'c' ;//output : 3
//        System.out.println(nextGreatestLetter(arr,target));

        int[] arr = {5,7,7,8,8,10};
        int target = 8 ;//output : 3,4
        int firstIndex = binarySearchStartAndEndPos(arr,target,true);
        int lastIndex = binarySearchStartAndEndPos(arr,target,false);
        int[] res = {firstIndex, lastIndex};
        System.out.println(Arrays.toString(res));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(letters[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

        static int binarySearch(int[] arr,int target) {
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(target<arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
//                }else{
//                    return arr[mid];
//                }
            }
            return arr[start%arr.length];
        }
        static char nextGreatestLetter2(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
    static int binarySearchStartAndEndPos(int[] arr, int target, boolean firstIndex) {
        int start = 0;
        int end = arr.length-1;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target<arr[mid]){
                end = mid - 1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
               ans = mid;
               if(firstIndex){
                   end = mid - 1;
               }else{
                   start = mid + 1;
               }
            }
        }
        return ans;
    }
}