package com.strings;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        String ans = "";
        int i = 0;
        int j = 0;
        while(j < s.length()){
            if(!ans.contains(String.valueOf(s.charAt(j)))){
                ans += s.charAt(j);
                j++;
            }else{
                ans = "";
                i++;
                j = i;
            }
            if(ans.length() > maxCount) maxCount = ans.length();
        }
        return maxCount;
    }
}
