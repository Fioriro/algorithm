package com.algorithm.tree.determine.CBT;

import com.algorithm.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DetermineCompletedBinaryTree {

    public static void main(String[] args) {

        Node rootCBT = new Node(1);
        rootCBT.left = new Node(2);
        rootCBT.right = new Node(3);
        rootCBT.left.left = new Node(4);
        rootCBT.left.right = new Node(5);
        rootCBT.right.left = new Node(6);

        Node rootNotCBT = new Node(1);
        rootNotCBT.left = new Node(2);
        rootNotCBT.right = new Node(3);
        rootNotCBT.left.left = new Node(4);
        rootNotCBT.right.left = new Node(5);

        System.out.println(isCBT01(rootCBT));
        System.out.println(isCBT01(rootNotCBT));
    }


    static boolean isCBT01(Node root) {
        if (root == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();

        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;
            if (
                    (leaf //Mark whether the first node with incomplete left and right children has been encountered
                            &&
                            (l != null || r != null)//if such node was encountered, and current node is not a leaf node, return
                    ) ||
                            (l == null && r != null)//left child is null but right child is not null, return false
            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
