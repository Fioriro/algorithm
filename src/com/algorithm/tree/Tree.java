package com.algorithm.tree;

import java.util.Objects;
import java.util.Stack;

public class Tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node(4);

        root.left = left1;
        root.right = right1;
        left1.left = left2;

        preOrder(root);
        System.out.println();
        postOrder(root);
    }

    public static void preOrder(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.print(cur.value + " ");
            if(cur.right != null){
                stack.push(cur.right);
            }if(cur.left != null){
                stack.push(cur.left);
            }
        }

    }

    public static void postOrder(Node root){
        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            help.push(cur);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        while (!help.isEmpty()){
            System.out.print(help.pop().value + " ");
        }
    }
}
