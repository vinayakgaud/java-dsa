package com.linkedList.recursion.insertion;

import com.linkedList.singlyLinkedList.GenericCustomLinkedList;

public class Main {
    public static void main(String[] args) {
        GenericCustomLinkedList<Integer> node = new GenericCustomLinkedList<>();
        node.insertFirst(3);
        node.insertFirst(1);
        node.insertFirst(2);
        node.displayList(); //2->1->3

        node.inserRec(2,5);
        node.displayList();//2->1->5->3

        node.inserRec(4,5);
        node.displayList();//2->1->5->3->5

        node.inserRec(0,5);
        node.displayList();//5->2->1->5->3->5

        node.inserRec(1,5);
        node.displayList();//5->5->2->1->5->3->5
    }
}
