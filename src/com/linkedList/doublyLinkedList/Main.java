package com.linkedList.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        GDLL<Integer> node = new GDLL<>();
        node.insertFirst(3);
        node.insertFirst(2);
        node.insertFirst(1);

        node.display();
        node.displayRev();

        node.insertAtPos(4,4);

        node.display();
        node.displayRev();

        System.out.println(node.size());
    }
}
