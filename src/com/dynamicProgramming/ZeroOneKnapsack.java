package com;

import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[][] t = new int[5][12];
        for (int[] t1 : t) Arrays.fill(t1,-1);
        int bag = 10;
        int[] w = {2,5,7};
        int[] v = {2,4,5};
        int n = 3;
        System.out.println(maxProfit(bag,w,v,n,t));
        for (int[] i : t){
            System.out.println(Arrays.toString(i));
        }
    }
    static int maxProfit(int bagWeight,int[] weight,int[] val,int n,int[][] t){
        //memoization checking matrix
        if(t[n][bagWeight] != -1) return t[n][bagWeight];
        //base condition
        if(n==0 || bagWeight ==0) return 0;
        //choice diagram
        if(weight[n-1] <= bagWeight){
            return t[n][bagWeight] = Math.max(val[n-1]+maxProfit(bagWeight - weight[n-1] ,weight,val,n-1,t),maxProfit(bagWeight,weight,val,n-1,t));
        }else{
            return t[n][bagWeight] = maxProfit(bagWeight,weight,val,n-1,t);
        }
    }
}
