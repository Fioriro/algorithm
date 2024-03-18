package com.algorithm.tree.successor;

import com.algorithm.tree.Node;
import com.algorithm.tree.traverse.inorder.Inorder;
import com.algorithm.utils.TreeUtil;
import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.List;

public class SuccessorNode {

    public static void main(String[] args) {

        String str = "1,2,3,4,5,6,7";
        Node head = TreeUtil.generateTreeBFS(str);
        List<Integer> list = Inorder.inorderTraversal(head);
        System.out.println(list);

        Node cur = head.left.right;
        Node node = successorNode(head, cur);
        System.out.println(node);

    }

    static Node successorNode(Node head, Node node) {
        if (head == null || node == null) {
            return null;
        }
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        storeAllFatherNodes(head, fatherMap);

        Node cur = node;

        if (cur.right != null) {
            Node leftest = cur.right;
            while (leftest.left != null) {
                leftest = leftest.left;
            }
            return leftest;
        } else {
            while (cur != head) {
                Node father = fatherMap.get(cur);
                if(cur == father.left){
                    return father;
                }else {
                    cur = father;
                }
            }

        }
        return null;
    }

    static void storeAllFatherNodes(Node head, HashMap<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);

        storeAllFatherNodes(head.left, fatherMap);
        storeAllFatherNodes(head.right, fatherMap);
    }
}
