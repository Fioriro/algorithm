package com.algorithm.linkedlist.lc141_linked_list_cycle;

import com.algorithm.linkedlist.Node;

public class lc141_linked_list_cycle_01 {

    static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
