package com.algorithm.utils;

import com.algorithm.linkedlist.Node;

public class LinkedListUtil {

    public static void traverse(Node head){
        if(head.next == null){
            System.out.println("当前链表为空！");
        }
        Node cur = head.next;
        while (cur.next != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}
