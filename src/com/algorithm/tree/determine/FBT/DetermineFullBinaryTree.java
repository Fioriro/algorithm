package com.algorithm.tree.determine.FBT;

import com.algorithm.tree.Node;

public class DetermineFullBinaryTree {

    public static void main(String[] args) {

    }

    static boolean isFBT(Node root){
        if(root == null){
            return true;
        }
        Info data = process(root);
        return data.nodes == (1 << data.height - 1);
    }

    static class Info{
        public int height;
        public int nodes;

        public Info(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }


    static Info process(Node root){
        //base case
        if(root == null){
            return new Info(0, 0);
        }

        //get left Info
        Info leftDate = process(root.left);
        //get right Info
        Info rightData = process(root.right);

        //handle the Info of cur node
        int height = Math.max(leftDate.height, rightData.height) + 1;
        int nodes = leftDate.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }
}
