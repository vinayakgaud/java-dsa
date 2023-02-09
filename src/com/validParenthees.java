package com;

import java.util.*;

public class validParenthees {
    public static void main(String[] args) {
        System.out.println(slidingWindowMaximum(new int[]{1,3,4,2,5,4,3,2},3));
        System.out.println(printMax(new int[]{1,3,4,2,5,4,3,2},3));
    }

    static ArrayList<Integer> printMax(int[] arr,int k){
        Deque<Integer> dQ = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        for(;i<k;i++){
            while(!dQ.isEmpty() && arr[i] >= arr[dQ.peekLast()]){
                dQ.removeLast();
            }
            dQ.addLast(i);
        }

        for(;i<arr.length;i++){
            if(dQ.peek() != null){
                ans.add(arr[dQ.peek()]);
            }
            while(!dQ.isEmpty() && dQ.peek() <= i-k){
                dQ.removeFirst();
            }

            while(!dQ.isEmpty() && arr[i] >= arr[dQ.peekLast()]){
                dQ.removeLast();
            }
            dQ.addLast(i);
        }
        if(dQ.peek() != null){
            ans.add(arr[dQ.peek()]);
        }
        return ans;
    }

    static ArrayList<Integer> slidingWindowMaximum(int[] arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        for(;i<k;i++){
            queue.add(arr[i]);
        }

        ans.add(queue.peek());
        queue.remove(arr[0]);
        for(;i<arr.length;i++){
            queue.add(arr[i]);
            ans.add(queue.peek());
            queue.remove(arr[i-k+1]);
        }
        return ans;
    }
    static boolean isValidMid(String s){
        Stack<Character> s1 = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch=='{'||ch=='['){
                s1.push(ch);
            }else{
                if(s1.isEmpty()) return false;
                if(
                        s1.peek() =='(' && ch==')'
                                ||  s1.peek() =='[' && ch==']'
                                ||  s1.peek() =='{' &&ch=='}'
                ) return false;
                else s1.pop();
            }
        }
        return s1.isEmpty();
    }
    public static boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isOpening(ch)){
                s1.push(ch);
            }else{
                if(s1.isEmpty()) return false;
                if(!isMatching(s1.peek(),ch)) return false;
                else s1.pop();
            }
        }
        return s1.isEmpty();
    }
    static boolean isOpening(char c){
        return c == '(' || c=='{'||c=='[';
    }
    static boolean isMatching(char a, char b){
        return (a =='(' && b==')') ||  (a =='[' && b==']') ||  (a =='{' && b=='}');
    }
}
