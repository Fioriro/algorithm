package com.algorithm.linkedlist.lc160_intersection_of_two_linked_lists;

import com.algorithm.linkedlist.Node;

public class lc160_intersection_of_two_linked_lists_01 {

    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
