package com.algorithm.tree.traverse.inorder;

import com.algorithm.tree.Node;

import java.util.ArrayList;
import java.util.List;
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

        //inorder(root);
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.value);
            curr = curr.right;
        }

        return res;
    }
}
