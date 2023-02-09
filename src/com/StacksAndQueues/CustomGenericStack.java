package com.StacksAndQueues;

import java.util.EmptyStackException;

public class CustomGenericStack<E> {
    private final Object[] arr;
    private static final int DEFAULT_SIZE = 10;
    private static int size = 0;

    public CustomGenericStack(int size){
        this.arr = new Object[size];
    }

    public CustomGenericStack(){
        this(DEFAULT_SIZE);
    }

    public void push(E data){
        if(size == arr.length-1) throw new StackOverflowError("Stack is full");
        arr[size++] = data;
    }

    public E pop(){
        if(size == 0) throw new EmptyStackException();
        E val = peek();
        size--;
        return val;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) arr[size-1];
    }

    public void display(){
        if(size == 0) System.out.print("[]");
        int i = 0;
        while(i < size){
            System.out.print(arr[i]+" ");
            i++;
        }
        System.out.println();
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        CustomGenericStack<Integer> s = new CustomGenericStack<>();
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("Peek "+s.peek());
        s.display();
        System.out.println("Size: "+s.size());
        System.out.println("Element remove: "+s.pop());
        s.display();
        System.out.println("Size: "+s.size());
        System.out.println("Element remove: "+s.pop());
        s.display();
        System.out.println("Size: "+s.size());
        System.out.println("Is empty: "+s.isEmpty());
        System.out.println("Element remove: "+s.pop());
        s.display();
        System.out.println("Size: "+s.size());
        System.out.println("Is empty: "+s.isEmpty());
    }
}
