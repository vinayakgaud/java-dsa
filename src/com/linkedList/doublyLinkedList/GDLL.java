package com.linkedList.doublyLinkedList;

public class GDLL<T> {
    private Node head;
    private Node tail;
    private int size;
    public GDLL(){
        this.size = 0;
    }
    public int size(){
        return size;
    }

    public void insertFirst(T data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail=node;
            size++;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        if(size == 1){
            tail.prev = node;
        }
        size++;

//        //Kunal's
//        Node node = new Node(data);
//        node.next = head;
//        node.prev = null;
//        if(head != null) head.prev = node;
//        head = node;
//
//        size++;
    }
    public void insertAtPos(int pos,T data){
        int i = 1;
        Node temp = head;
        while(i <pos-1){
            temp = temp.next;
            i++;
        }
        Node node = new Node(data);
        node.next = temp.next;
        if(temp.next != null){
            temp.next.prev = node;
        }
        temp.next = node;
        node.prev = temp;
        tail = node;
        size++;
    }
    public void display(){
        Node temp = head;
        System.out.print("Start <-> ");
        while(temp != null){
            System.out.print("["+temp.data+"] <-> ");
            temp = temp.next;
        }
        System.out.println(" End");
    }
    public void displayRev(){
        Node temp = tail;
        System.out.print("Start <-> ");
        while(temp != null){
            System.out.print("["+temp.data+"] <-> ");
            temp = temp.prev;
        }
        System.out.println(" End");
    }
    private class Node{
        private T data;
        private Node next;
        private Node prev;

        public Node(T data){
            this.data = data;
        }
    }
}
