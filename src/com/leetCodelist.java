package com;

import java.util.*;

public class leetCodelist {
    public static void main(String[] args) {
////        System.out.println(rr(new int[]{-1,-1,1},0));
//        System.out.println(longestSumSubArray(new int[]{-5,4,6,-3,4,-1}));
//        System.out.println(previousSmallerElement(new int[]{4,10,5,18,20,15,3,12}));
//        System.out.println(previousGreaterElement(new int[]{4,10,5,18,20,15,3,12}));
//        ArrayList<Integer> ans = nextGreaterElement(new int[]{4,10,5,18,20,15,3,12});
//        for(int i = ans.size()-1;i>=0;i--){
//            System.out.print(ans.get(i)+" ");
//        }
//        System.out.println();
//        ArrayList<Integer> res = nextSmallerElement(new int[]{4,10,5,18,20,15,3,12});
//        for(int i = res.size()-1;i>=0;i--){
//            System.out.print(res.get(i)+" ");
//        }
        int[] nums = {2,3,4,5};
        int lenOfWindow = 3;
        System.out.println("expected o/p: 9 , 8, 9, 10, 14, 13, 14, 16, 16, 12 (16)");
        System.out.println(maxSum(nums,lenOfWindow));
    }

    static int maxSum(int[] arr, int k){
        int max;
        int sum = 0;
        int i = 0;
        for(;i<k;i++){
            sum += arr[i];
        }
        max = sum;

        for(;i<arr.length;i++){
            sum += arr[i];
            sum -= arr[i-k];
            max = Math.max(max, sum);

        }
        return max;
    }
    static int rr(int[] nums,int k){
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            if(sum > k){
                sum = nums[i];
            }
            if(sum == k){
                sum = nums[i];
                list.add(sum);
            }
            if(sum < nums[i]){
                sum = nums[i];
            }
            if(sum == k){
                sum = nums[i];
                list.add(sum);
            }
        }
        return list.size();
    }

    static int longestSumSubArray(int[] arr){
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max,sum);
            if(sum < 0){
               sum = 0;
            }
        }

        return max;
    }

    static ArrayList<Integer> previousSmallerElement(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> s = new Stack<>();
        for(int i =0;i< arr.length;i++){
            while(!s.isEmpty() && s.peek() >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) ans.add(-1);
            else ans.add(s.peek());

            s.push(arr[i]);
        }

        return ans;
    }
    static ArrayList<Integer> previousGreaterElement(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> s = new Stack<>();
        for(int i =0;i< arr.length;i++){
            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) ans.add(-1);
            else ans.add(s.peek());

            s.push(arr[i]);
        }

        return ans;
    }
    static ArrayList<Integer> nextGreaterElement(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> s = new Stack<>();
        for(int i =arr.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) ans.add(-1);
            else ans.add(s.peek());

            s.push(arr[i]);
        }

        return ans;
    }
    static ArrayList<Integer> nextSmallerElement(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> s = new Stack<>();
        for(int i =arr.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek() >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) ans.add(-1);
            else ans.add(s.peek());

            s.push(arr[i]);
        }

        return ans;
    }
}
