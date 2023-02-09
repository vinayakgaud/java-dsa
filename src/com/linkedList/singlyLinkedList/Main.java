package com.linkedList.singlyLinkedList;

public class Main {
    public static void main(String[] args) {
        GenericCustomLinkedList<Integer> node = new GenericCustomLinkedList<>();
//
//        node.insert(0);
//        node.insert(1);
//        node.insert(2);
//        node.insert(3);
////        node.displayList();
////        System.out.println("Initial size: "+node.size());
////        node.insertAtGivenPosition(2,4);
////        node.displayList();
////        System.out.println("After insertAtGivenPosition size: "+node.size());
////        node.remove(2);
////        node.displayList();
////        System.out.println("After remove size: "+node.size());
////
////        node.set(2,4);
////        node.displayList();
////        System.out.println("after setting size: "+node.size());
////
////        System.out.println(node.get(3));
//        node.insertAtGivenPosition(5,1);
//
////        node.removeByValue(1);
////        node.remove(0);
//        node.displayList();

        node.insert(3);
        node.insert(4);
        node.insert(6);
        node.insert(5);
        node.displayList();
//        GenericCustomLinkedList ans = new GenericCustomLinkedList(node.rev());
//        ans.displayList();
//        node.revRec(node.get(0));
//        node.displayList();
//        node.bubbleSort();
//        node.displayList();
//        node.inPlaceRev();
//        node.displayList();
        node.rotateRight(node.get(0),2);
        node.displayList();
    }
}
