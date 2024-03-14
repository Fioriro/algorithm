package com.algorithm.tree.determine.BBT;

import com.algorithm.tree.Node;

public class DetermineBalanceBinaryTree {
    public static void main(String[] args) {
        //balance binary tree
        //for any subtree, the difference of height between left tree and right tree is less than 2


    }

    static boolean isBBT(Node root){
        return process(root).isBalanced;
    }

    static class ReturnType{
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    static ReturnType process(Node x){
        if(x == null){
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        boolean isBalanced = leftData.isBalanced && rightData.isBalanced &&
                (Math.abs(leftData.height - rightData.height) < 2 );
        int height = Math.max(leftData.height, rightData.height) + 1;

        return new ReturnType(isBalanced, height);
    }
}
