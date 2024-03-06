package com.algorithm.tree.traverse.recursion;

import com.algorithm.tree.Node;

public class Recursion {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node(4);

        root.left = left1;
        root.right = right1;
        left1.left = left2;

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    static void preorder(Node root){
        if(root != null){
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }
}
