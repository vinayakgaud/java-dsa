package com.strings;

import java.util.HashSet;
import java.util.Set;

//it is medium level question uses sliding window and hash table look into solution
public class LeetCodeLongestSubString {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0;right < s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
