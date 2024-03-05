package com.algorithm.linkedlist.partition;

import com.algorithm.linkedlist.Node;
import com.algorithm.linkedlist.singly.SinglyLinkedList;
import com.algorithm.utils.ArrayUtil;

public class PartitionLinkedList {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(20, 20);
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i : arr) {
            SinglyLinkedList.insertTail(list, i);
        }
        SinglyLinkedList.traverse(list);
        Node head = partition(list.head, 10);
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static Node partition(Node head, int pivot){
        Node sh = null; //small partition head
        Node st = null; //small partition tail
        Node eh = null; //equal partition head
        Node et = null; //equal partition tail
        Node bh = null; //big partition head
        Node bt = null; //big partition tail
        Node next = null;//save next node
        while (head != null){
            next = head.next;
            head.next = null; // unlink the node
            if(head.value < pivot){
                if(sh == null){// first node in less than partition
                    sh = head;
                    st = head;
                }else {
                    st.next = head;
                    st = head;
                }
            }else if(head.value == pivot){
                if(eh == null){// first node in equal partition
                    eh = head;
                    et = head;
                }else{
                    et.next = head;
                    et = head;
                }
            }else{
                if(bh == null){// first node in greater than partition
                    bh = head;
                    bt = head;
                }else{
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        // link the partitions
        if(st != null) {
            st.next = eh;
            et = et == null ? st : et;//in the next step, which one connected to bh, which one is et
        }
        if(et != null) {
            et.next = bh;
        }
        return sh != null ? sh : (eh != null ? eh : bh);
    }
}
