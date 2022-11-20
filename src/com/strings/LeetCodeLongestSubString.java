package com.strings;
//it is medium level question uses sliding window and hash table look into solution
public class LeetCodeLongestSubString {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(String.valueOf(res).indexOf(s.charAt(i)) > 0 && i != s.length()-1){
                res.delete(0,i+1);
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.length();
    }
}
