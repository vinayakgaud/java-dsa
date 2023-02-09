package com.StacksAndQueues;

import java.util.NoSuchElementException;

public class CustomQueue<E> {
    private final Object[] arr;
    private int start = 0;
    private int end = 0;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size) {
        this.arr = new Object[size];
    }

    public void enqueueCircular(E data) throws Exception {
        arr[end++] = data;
        end = end % arr.length;
        size++;
    }

//    public E dequeue(){
//        if(size == 0) throw new NoSuchElementException("No element present");
//        E val = peek();
//        start++;
//        size--;
//        return val;
//    }
    public E dequeueCircular(){
        @SuppressWarnings("unchecked")
        E val = (E) arr[start++];
        start %= arr.length;
        size--;
        return val;
    }

    public int size(){
        return size;
    }

//    public E dequeueT(){
//        if(size == 0) throw new NoSuchElementException("No element present");
//        E val = peek();
//        for (int i = 0; i < end-1; i++) {
//            arr[i] = arr[i+1];
//        }
//        end--;
//        size--;
//        return val;
//    }

    public void display(){
       int i = start;
       if(size == 0) {
           System.out.println("[]"); return;
       }
        System.out.print("[");
       do {
           System.out.print(arr[i]+" ");
           i++;
           i %= arr.length;
       }while (i != end);
        System.out.println("]");
    }

//    @SuppressWarnings("unchecked")
//    public E peek(){
//        return (E)arr[start];
//    }

    public static void main(String[] args) throws Exception {
        CustomQueue<Integer> s = new CustomQueue<>(5);
        s.enqueueCircular(4);
        s.enqueueCircular(41);
        s.enqueueCircular(42);
        s.enqueueCircular(43);
        s.enqueueCircular(44);
        s.display();

        System.out.println(s.dequeueCircular());
        s.display();

        s.enqueueCircular(133);
        s.display();
    }
}
