package com.linkedList.circularLinkedList;

public class CLL<T> {

    private Node head;
    private Node tail;
    private int size;

    public CLL(){
        this.size = 0;
    }

    public int size(){
        return size;
    }
    public void insertLast(T data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            head.next = head;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void insertFirst(T data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            head.next = head;
            size++;
            return;
        }
        node.next = head;
        head = node;
        tail.next = head;
        size++;
    }
    public void remove(int pos){
        Node temp = head;
        if(pos == 0 ) {
            head = head.next;
            return;
        }
        if(pos > size){
            System.out.println("No element present");
            return;
        }
        int i = 1;
        while(i < pos-1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public int length(){
        Node f = head;
        Node s = head;
        while(f != s){
            f = f.next.next;
            s = s.next;
        }
        int count = 1;
        s = s.next;
        while(s != f){
            count++;
            s = s.next;
        }
        return count;
    }

    public void display(){
        if(head == null){
            System.out.println("Empty List: []");
            return;
        }
        Node temp = head.next;
        System.out.print("Start -> ");
        System.out.print("["+head.data+"] -> ");
        while(temp != head){
            System.out.print("["+temp.data+"] -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    private class Node{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
        }
    }

}
