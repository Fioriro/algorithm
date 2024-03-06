package com.algorithm.tree.traverse.postorder;

import com.algorithm.tree.Node;

import java.util.Stack;

public class Postorder {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node(4);

        root.left = left1;
        root.right = right1;
        left1.left = left2;

        postorder(root);
    }

    static void postorder(Node root){
        if(root == null){
            System.out.println("tree is empty!");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            help.push(cur);
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        while (!help.isEmpty()){
            System.out.print(help.pop().value + " ");
        }
        System.out.println();
    }
}
