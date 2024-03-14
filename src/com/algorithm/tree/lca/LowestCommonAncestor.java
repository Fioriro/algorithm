package com.algorithm.tree.lca;

import com.algorithm.tree.Node;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lca(root, root.left.left, root.right.right));
    }

    static Node lca(Node head, Node node1, Node node2){
        HashMap<Node, Node> fatherMap = new HashMap<>();
        HashSet<Node> set = new HashSet<>();

        fatherMap.put(head, head);
        storeAllFatherNodes(head, fatherMap);


        Node cur1 = node1;
        Node cur2 = node2;

        while (cur1 != fatherMap.get(cur1)){// not root node
            set.add(cur1);
            cur1 = fatherMap.get(cur1);
        }
        set.add(head);

        while (cur2 != fatherMap.get(cur2)){
            if(set.contains(cur2)){
                return cur2;
            }
            cur2 = fatherMap.get(cur2);
        }
        return head;
    }

    static void storeAllFatherNodes(Node head, HashMap<Node, Node> fatherMap){
        if(head == null){
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);

        storeAllFatherNodes(head.left, fatherMap);
        storeAllFatherNodes(head.right, fatherMap);
    }
}
