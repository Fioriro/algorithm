package com.algorithm.linkedlist.lc138_copy_list_with_random_pointer;

import com.algorithm.linkedlist.Node;

import java.util.HashMap;

public class lc138_copy_list_with_random_pointer_01 {

    public static Node duplicate(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        Node duplicateHead = map.get(head);
        return duplicateHead;
    }
}
