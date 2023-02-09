package com.strings;

import java.lang.reflect.Array;
import java.util.*;

public class FirstKOccurences {
    public static void main(String[] args) {
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(s.hasNextInt()){
            n1.add(s.nextInt());
        }
        String s1 = s.next();
        while(s.hasNextInt()){
            n2.add(s.nextInt());
        }
        String s2 = s.next();
        System.out.println(n1);
        System.out.println(n2);

        System.out.println(occ(s1,n1.get(1)));
        System.out.println(occ(s2,n2.get(1)));
    }
    static String occ(String s,int k){
        StringBuilder s1 = new StringBuilder();
        Map<Character,Integer> m = new HashMap<>();
        for(char c:s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(char c:m.keySet()){
            while(m.get(c) > k){
                m.put(c,m.get(c)-1);
            }
        }
            for(int j = 0;j<s.length();j++){
                if(m.get(s.charAt(j)) > 0){
                    s1.append(s.charAt(j));
                    m.put(s.charAt(j),m.get(s.charAt(j))-1);
                }
            }
        return s1.toString();
    }
}
