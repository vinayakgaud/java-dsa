package com.linkedList;

import com.linkedList.singlyLinkedList.GenericCustomLinkedList;

import java.util.ArrayList;
import java.util.List;

public class leetCode {
    public static void main(String[] args) {
        int[] ar  = new int[]{1,1,2,5,5};
        ListNode head = new ListNode(ar[0]);
        ListNode s = new ListNode(ar[1]);
        ListNode y = new ListNode(ar[2]);
        ListNode z = new ListNode(ar[3]);
        ListNode x = new ListNode(ar[3]);
        head.next = s;
        s.next = y;
        y.next = z;
        z.next = x;
        ListNode h = deleteDuplicates(head);

        ListNode t = h;
        while(t!= null){
            System.out.print(t.val+" ");
            t = t.next;
        }
    }
     //Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
        public static ListNode deleteDuplicates(ListNode head) {
            List<Integer> set = new ArrayList<>();
            List<Integer> dup = new ArrayList<>();

            ListNode temp = head;
            while(temp != null){
                if(!set.contains(temp.val)){
                    set.add(temp.val);
                }else{
                    dup.add(temp.val);
                }
                temp = temp.next;
            }

            ListNode node = new ListNode(-1);
            ListNode newHead = node;
            temp = head;

            while(temp != null){
                if(!dup.contains(temp.val)){
                    node.next = temp;
                    node = node.next;
                }
                temp = temp.next;
            }
            node.next = null;
            return newHead.next;
        }
}
