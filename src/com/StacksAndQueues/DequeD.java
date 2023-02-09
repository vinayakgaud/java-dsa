package com.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeD {

    //can push or remove from both side
    //null element is not supported
    //faster than linked list and stack
    //not thread safe
    //no capacity restriction
    public static void main(String[] args) {
        Deque<Integer> s = new ArrayDeque<>();
        s.add(4);
        s.addFirst(3);
        s.addLast(5);
        System.out.println(s);
        System.out.println(s.remove());
        System.out.println(s.remove(4));
        System.out.println(s.removeFirst());
        System.out.println(s.removeLast());
    }
}
