package com.algorithm.linkedlist.singly;

import com.algorithm.linkedlist.Node;
import com.algorithm.utils.ArrayUtil;

public class SinglyLinkedList01 {
    Node head;

    public static void main(String[] args) {
        int[] arr = {1, 2,3,4,5,6,7,8,9,10};
        ArrayUtil.traverseArray(arr);
        SinglyLinkedList01 list = new SinglyLinkedList01();
        for (int i : arr) {
            //insertHead(list, i );
            insertTail(list, i);
        }
        traverse(list.head);
        //delete(list, 5);
        traverse(reserve(list));

    }

    public static void delete(SinglyLinkedList01 list, int value){
        Node cur = list.head;
        if(cur == null){
            System.out.println("linked list is empty!");
            return;
        }
        while (cur.next != null){
            if(cur.next.value == value){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        System.out.println("no such node!");

    }

    public static void insertHead(SinglyLinkedList01 list, int value){
        Node cur = list.head;
        Node newNode = new Node(value);
        if(cur == null){
            list.head = newNode;
        }else {
            newNode.next = list.head;
            list.head = newNode;
        }
    }

    public static void insertTail(SinglyLinkedList01 list, int value){
        Node cur = list.head;
        Node newNode = new Node(value);
        if(cur == null){
            list.head = newNode;
            return;
        }
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
    }

    public static void traverse(Node head){
        Node cur = head;
        System.out.println("traverse linked list:");
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static Node reserve(SinglyLinkedList01 list){
        Node cur = list.head;
        if(cur == null || cur.next == null){
            return cur;
        }
        Node prev = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
