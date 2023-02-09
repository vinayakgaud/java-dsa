package com.trees;

import java.util.*;

public class BuildTree {
    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node createTree(){
        Scanner sc = new Scanner(System.in);
        Node root;
        System.out.println("Data: ");
        int val = sc.nextInt();
        root = new Node(val);
        if(val == -1) return null;

        System.out.println("Left for "+val);
        root.left = createTree();

        System.out.println("Right for "+val);
        root.right = createTree();

        return root;
    }

    public static void main(String[] args) {
        Node root = createTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        levelOrder(root,res);
        System.out.println();
        for (ArrayList<Integer> s:res){
            System.out.print(s +" ");
        }

        System.out.println();
        System.out.println("maxHeight: "+ maxHeight(root));
        System.out.println("minHeight: "+minHeight(root));

        System.out.println("Size: "+size(root));

        System.out.println("Max: "+max(root));
        System.out.println("Min: "+min(root));

        System.out.println("isBST: "+isBST(root,0));
    }



    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    static void levelOrder(Node root, ArrayList<ArrayList<Integer>> ans){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int lvl = queue.size();
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0;i<lvl;i++){
                Node node = queue.poll();
                if(node != null){
                    res.add(node.data);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(!res.isEmpty()){
                ans.add(res);
            }
        }
    }

    static int maxHeight(Node root){
        if(root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }
    static int minHeight(Node root){
        if(root == null) return 0;
        return Math.min(minHeight(root.left),minHeight(root.right)) + 1;
    }
    static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    static int max(Node root){
        int max = Integer.MIN_VALUE;
        if(root == null) return max;
        if(max < root.data) max = root.data; // we can directly take root.data instead of max
        return Math.max(max,Math.max(max(root.left),max(root.right)));
    }
    private static int min(Node root) {
        int min = Integer.MAX_VALUE;
        if(root == null) return min;
        if(min > root.data) min = root.data;// we can directly take root.data instead of min
        return Math.min(min,Math.min(min(root.left),min(root.right)));
    }
    static boolean isBST(Node root,int prev){
        //we can inorder and then check if we are getting sorted array then it is BST
        //we can store curr elemnt in var and check if curr element is greatr then that prev or not for all iterations
        if(root.left != null){
            isBST(root.left,prev);
        }
        if(prev > root.data) return false;
        prev = root.data;

        if(root.right != null){
            isBST(root.right,prev);
        }
        return true;
    }
    static boolean isBSTwithRange(Node root,int min,int max){
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;
        return isBSTwithRange(root.left,min,root.data-1) && isBSTwithRange(root.right, root.data + 1,max );
    }
}
