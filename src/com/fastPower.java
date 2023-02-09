package com;

import java.util.*;

public class fastPower {
    public static void main(String[] args) {
//        ArrayList <ArrayList<Integer>> ans = binTreeSortedLevels(new int[]{7,6,5,4,3,2,1});
//        for (ArrayList<Integer> row : ans){
//            System.out.println(row);
//        }
        int[] nums = {1,2,3};
//        System.out.println(subArray(nums,0));
//        System.out.println(sub(nums,0));
        System.out.println(Arrays.toString(subArrayT(nums,5)));
    }

    static int[] subArrayT(int[] nums,int k){
        int[] res = {-1,-1};
        int curSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            curSum += nums[i];
            if(curSum == k){
                res[0] = 0;
                res[1] = i;
                break;
            }
            if(map.containsKey(curSum - k)){
                res[0] = map.get(curSum-k)+1;
                res[1] = i;
                break;
            }
            map.put(curSum,i);
        }
        return res;
    }

    static int fP(int a, int b){
        int res = 1;
        while(b > 0){
            if( (b&1) != 0){
                res *= a;
            }
            a *= a;
            b >>= 1;
        }
        return res;
    }
    static int sub(int[] nums,int k){
        Map<Integer,Integer>map=new HashMap<>();
         map.put(0,1);
         int sum=0;
         int res=0;
         for(int i=0;i<nums.length;i++){
             sum+=nums[i];
             if(map.containsKey(sum-k)){
                 res+=map.get(sum-k);
             }
             map.put(sum,map.getOrDefault(sum,0)+1);
         }
         return res;
    }

    static int subArray(int[] nums, int k){
        int prefixSum = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> cc = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            prefixSum += nums[i];
            if(nums[i] == k){
                count++;
                continue;
            }
            if(prefixSum == k){
                count++;
            }
            if(cc.contains(prefixSum - k)){
                count++;
            }
            cc.add(prefixSum);
        }
        return count;
    }
    public static ArrayList <ArrayList<Integer>> binTreeSortedLevels (int arr[])
    {
        // your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pp = new PriorityQueue<>();
        int range = 1;
        int j = 0;
        for(int k = 0;k< arr.length;k++){
            for(int i = j; i < j + range && i < arr.length; i++ ){
                pp.add(arr[i]);
            }
            range += range;
            j = range-1;
            ArrayList<Integer> inner = new ArrayList<>();
            while(!pp.isEmpty()){
                inner.add(pp.poll());
            }
            if(!inner.isEmpty()){
                ans.add(inner);
            }
        }
        return ans;
    }
}
