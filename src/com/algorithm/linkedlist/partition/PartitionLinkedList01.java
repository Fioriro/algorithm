package com.algorithm.linkedlist.partition;

import com.algorithm.linkedlist.Node;
import com.algorithm.linkedlist.singly.SinglyLinkedList;
import com.algorithm.utils.ArrayUtil;

public class PartitionLinkedList01 {

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

    static Node partition(Node head, int pivot){
        Node sh = null;
        Node st = null;
        Node eh = null;
        Node et = null;
        Node bh = null;
        Node bt = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sh == null){
                    sh = head;
                    st = head;
                }else {
                    st.next = head;
                    st = head;
                }
            }else if(head.value == pivot){
                if(eh == null){
                    eh = head;
                    et = head;
                }else {
                    et.next = head;
                    et = head;
                }
            }else{
                if(bh == null){
                    bh = head;
                    bt = head;
                }else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }


        if(sh != null){
            st.next = eh;
            et = et == null ? st : et;
        }
        if(et != null){
            et.next = bh;
        }
        return sh != null ? sh : (eh != null ? eh : bh);
    }
}
