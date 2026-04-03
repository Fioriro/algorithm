package com.algorithm.linkedlist.lc142_linked_list_cycle_ii;

import com.algorithm.linkedlist.Node;

public class lc142_linked_list_cycle_ii_01 {

    static Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node s = head;
        Node f = head;
        boolean flag = false;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;

        f = head;
        while (f != s) {
            s = s.next;
            f = f.next;
        }
        return f;
    }
}
