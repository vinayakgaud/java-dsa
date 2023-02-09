package com.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumCoin {
    public static void main(String[] args) {
        int[] dp = new int[6];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        System.out.println(minCoins(new int[]{1,2,3},5,dp));
        System.out.println(Arrays.toString(dp));
    }
    static int minCoins(int[] coinArray, int totalSum,int[] dp){
        if(totalSum == 0) return 0;
        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
        for (int j : coinArray) {
            if (totalSum - j >= 0) {
                int subAns = 0;
                if (dp[totalSum - j] != -1) {
                    subAns = dp[totalSum - j];
                } else {
                    subAns = minCoins(coinArray, totalSum - j, dp);
                }
                if (/*subAns != Integer.MAX_VALUE &&*/ subAns + 1 < min) {
                    min = subAns + 1;
                }
            }
        }
        dp[totalSum] = min;
        return min;
    }
}
