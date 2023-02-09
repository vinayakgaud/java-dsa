package com.StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StacksAndQueues {
    public static void main(String[] args) {
//        Stack<Integer> s = new Stack<>();
//        s.push(3);
//        s.push(4);
//        s.push(5);
//        s.push(6);
//        s.push(8);
//
//        System.out.println(s);
//
//        System.out.println(s.peek());
//        System.out.println(s.pop());
//
//        System.out.println(s.search(4));
        Queue<Integer> q = new LinkedList<>(); //queue is interface and linked list implements
        //deque(deck - double end queue) and deque implements queue
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.remove());
        q.offer(4);
        System.out.println(q);
    }
}
