package com.linkedList.circularLinkedList;

public class Main {
    public static void main(String[] args) {
        CLL<Integer> node = new CLL<>();
        node.insertLast(1);
        node.insertLast(2);
        node.insertLast(3);
        node.insertLast(4);
        node.insertFirst(5);
        node.insertFirst(6);

        System.out.println(node.length());
        System.out.println(node.size());
    }
}
