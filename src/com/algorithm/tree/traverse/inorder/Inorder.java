package com.algorithm.tree.traverse.inorder;

import com.algorithm.tree.Node;

import java.util.Stack;

public class Inorder {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node(4);

        root.left = left1;
        root.right = right1;
        left1.left = left2;

        inorder(root);
    }

    static void inorder(Node root){
        if(root == null){
            System.out.println("tree is empty!");
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node cur = root;
        while (cur.left != null){
            stack.push(cur.left);
            cur = cur.left;
        }
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.value + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
    }
}
