package com.linkedList.singlyLinkedList;

public class GenericCustomLinkedList<T>{
    private Node head;
    private Node tail;

    private int size;

    public GenericCustomLinkedList(){
        this.size = 0;
    }
    public GenericCustomLinkedList(Node r){
        head = r;
    }

    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insert(int data){
        Node node = new Node(data);
        if(head == null &&
           /*head == null is not required as head will always be null is tail is null and vice versa*/
           tail == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtGivenPosition(int index, int data){
        Node node = new Node(data);
        if(index == 0){
            node.next = head;
            head = node;
            size++;
            return;
        }
        if(index == size -1){
            tail.next = node;
            tail = node;
            size++;
            return;
        }
        Node temp = head;
        int i = 1;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }
    public void set(int index,int data){
        Node temp = head;
        int i = 1;
        while(i < index){
            temp = temp.next;
            i++;
        }
        temp.data = data;
    }

    public Node get(int index){
        Node temp = head;
        int i = 1;
        while(i < index){
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public void remove(int index){
        if(index == 0 || index-1==0) {
            head = head.next;
            size--;
            return;
        }
        if(head == null) tail = null;
        Node temp = head;
        int i = 1;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        if(temp.next == null) {
            tail = temp;
        }
        size--;
    }

    public void removeByValue(int data){
        Node temp = head;
        int i = 1;
        while(temp.data != data){
            temp = temp.next;
            i++;
        }
        remove(i);
    }
    public void bubbleSort(){
        bubbleSort(size,0);
    }
    public void bubbleSort(int r, int c){
        if(r == 0){
            return;
        }
        if(c < r){
            Node first = get(c);
            Node second = get(c+1);

            if(first.data > second.data){
                if(first == head){
                    first.next = second.next;
                    head = second;
                    second.next = first;
                }else if(second == tail){
                    Node p = get(c-1);
                    p.next = second;
                    second.next = first;
                    tail = first;
                    first.next = null;
                }else{
                    Node p = get(c-1);
                    first.next = second.next;
                    p.next = second;
                    second.next = first;
                }
            }
            bubbleSort(r,c+1);
        }
        else  bubbleSort(r-1,0);


    }

    public void inserRec(int index, int data){
        if(index == 0){
            Node node = new Node(data);
            node.next = head;
            head = node;
            return;
        }
        insertRec(index,data,head);
    }
    private Node insertRec(int index,int data,Node node){
        if(index == 0){
            Node node1 = new Node(data);
            node1.next = node;
            return node1;
        }
        node.next = insertRec(index-1,data,node.next);
        return node;
    }

    public void displayList(){
        Node temp = head;
        System.out.print("Start -> ");
        while(temp != null){
            System.out.print("["+temp.data+"]" + " -> ");
            temp = temp.next;
        }
        System.out.println(" End");
    }
    public int size(){
        return size;
    }

    public Node rev(){
        Node node = new Node(-1);
        Node newHead = node;
        while(size != 0){
            node.next = this.get(size);
            node = node.next;
            size--;
        }
        node.next = null;
        return newHead.next;
    }
    public void revRec(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        revRec(node.next);
        tail.next = node;
        tail = node;
        node.next = null;
    }
    public void inPlaceRev(){
        Node prev = null;
        Node pre = head;
        Node next = head.next;

        while(pre != null){
            pre.next = prev;
            prev = pre;
            pre = next;
            if(next != null) next = next.next;
        }
        head = prev;
    }

    public Node rotateRight(Node head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = size(head);
        Node newHead = head;
        while(k-- > 0){
            Node node = get(len,head);
            Node sec = get(len-1,head);
            sec.next = null;
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
    public Node get(int index,Node head){
        Node t = head;
        int i = 1;
        while(i < index){
            t = t.next;
            i++;
        }
        return t;
    }
    public int size(Node head){
        int c = 0;
        Node t = head;
        while(t != null){
            c++;
            t = t.next;
        }
        return c;
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
