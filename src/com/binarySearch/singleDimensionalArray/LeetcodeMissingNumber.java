package com.binarySearch.singleDimensionalArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetcodeMissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(missNum(arr));
    }
    static int missNum(int[] nums){
        int n = nums.length;
        int tsum = (n * (n + 1)) /  2;
        int sum = 0;
        for(int n1 : nums){
            sum += n1;
        }
        return tsum - sum;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            for(int j =0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    s.add(nums1[i]);
                }
            }
        }
        System.out.println(s);
        int j = 0;
        int[] res = new int[s.size()];
        for(Integer i : s){
            res[j++] = i;
        }
        return res;
    }
}
