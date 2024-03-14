package com.algorithm.tree.determine.BST;

import com.algorithm.tree.Node;

import java.util.Stack;

public class DetermineSearchBinaryTree {
    public static void main(String[] args) {
        Node rootBST = new Node(8);
        rootBST.left = new Node(3);
        rootBST.right = new Node(10);
        rootBST.left.left = new Node(1);
        rootBST.left.right = new Node(6);
        rootBST.right.right = new Node(14);
        rootBST.right.right.left = new Node(13);

        Node rootNotBST = new Node(8);
        rootNotBST.left = new Node(10);
        rootNotBST.right = new Node(3);
        rootNotBST.left.left = new Node(1);
        rootNotBST.left.right = new Node(6);
        rootNotBST.right.right = new Node(14);
        rootNotBST.right.right.left = new Node(13);

        System.out.println(isBST(rootBST));
        System.out.println(isBST(rootNotBST));

    }


    public static boolean isBST(Node root){
        if(root == null){
            return false;
        }

        int preVal = Integer.MIN_VALUE;
        //perform inorder traverse
        Node cur = root;
        Stack<Node>  stack = new Stack<>();
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(cur.value < preVal){
                return false;
            }
            preVal = Math.max(preVal,  cur.value);
            cur = cur.right;
        }

        return true;
    }
}
