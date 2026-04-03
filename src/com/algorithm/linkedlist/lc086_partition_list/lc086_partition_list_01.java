package com.algorithm.linkedlist.lc086_partition_list;

import com.algorithm.linkedlist.Node;

public class lc086_partition_list_01 {

    public static Node partition(Node head, int pivot) {
        Node sh = null; // small partition head
        Node st = null; // small partition tail
        Node eh = null; // equal partition head
        Node et = null; // equal partition tail
        Node bh = null; // big partition head
        Node bt = null; // big partition tail
        Node next = null; // save next node
        while (head != null) {
            next = head.next;
            head.next = null; // unlink the node
            if (head.value < pivot) {
                if (sh == null) {// first node in less than partition
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            } else if (head.value == pivot) {
                if (eh == null) {// first node in equal partition
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            } else {
                if (bh == null) {// first node in greater than partition
                    bh = head;
                    bt = head;
                } else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        // link the partitions
        if (st != null) {
            st.next = eh;
            et = et == null ? st : et;
        }
        if (et != null) { // at least one of less than partition or equal partition is not empty
            et.next = bh;
        }
        return sh != null ? sh : (eh != null ? eh : bh);
    }
}
