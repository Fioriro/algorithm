package com.algorithm.tree.traverse.preorder;

import com.algorithm.tree.Node;

import java.util.Stack;

public class Preorder {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node(4);

        root.left = left1;
        root.right = right1;
        left1.left = left2;

        preorder(root);
    }

    static void preorder(Node root){
        if(root == null){
            System.out.println("tree is empty!");
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.print(cur.value + " ");
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
}
