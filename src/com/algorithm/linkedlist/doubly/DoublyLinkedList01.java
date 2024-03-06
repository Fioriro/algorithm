package com.algorithm.linkedlist.doubly;

import com.algorithm.linkedlist.Node;
import com.algorithm.utils.ArrayUtil;

public class DoublyLinkedList01 {

    public Node head;
    public Node tail;

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayUtil.traverseArray(arr);
        DoublyLinkedList01 list = new DoublyLinkedList01();
        for (int i : arr) {
            //insertHead(list, i);
            insertTail(list,i);
        }
        traverse(list);
        //delete(list, 1);
        reverse(list);
        traverse(list);
    }

    public static Node reverse(DoublyLinkedList01 list){
        Node cur = list.head;
        if(cur == null){
            System.out.println("doubly linked list is empty!");
            return cur;
        }
        Node next = null;
        while (cur != null){
            if(cur.prev == null){
                list.tail = cur;
            }
            if(cur.next == null){
                list.head = cur;
            }
            next = cur.next;
            cur.next = cur.prev;
            cur.prev = next;
            cur = next;
        }
        return list.head;
    }

    public static void delete(DoublyLinkedList01 list, int value) {
        if (list.head == null) {
            System.out.println("doubly linked list is empty!");
            return;
        }

        Node cur = list.head;
        while (cur != null && cur.value != value) {
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("no such node!");
            return;
        }

        if (cur.next != null) {
            cur.next.prev = cur.prev;
        } else {
            list.tail = cur.prev;
        }

        if (cur.prev != null) {
            cur.prev.next = cur.next;
        } else {
            list.head = cur.next;
        }
    }

    public static void insertTail(DoublyLinkedList01 list, int value){
        Node newNode = new Node(value);
        if(list.tail == null){
            list.head = newNode;
            list.tail = newNode;
        }else {
            list.tail.next = newNode;
            newNode.prev = list.tail;
            list.tail = newNode;
        }
    }

    public static void insertHead(DoublyLinkedList01 list, int value){
        Node newNode = new Node(value);
        if(list.head == null){
            list.head = newNode;
            list.tail = newNode;
        }else {
            list.head.prev = newNode;
            newNode.next = list.head;
            list.head = newNode;
        }
    }

    public static void traverse(DoublyLinkedList01 list){
        Node cur = list.head;
        if(cur == null){
            System.out.println("doubly linked list is null!");
        }else {
            System.out.println("traverse doubly linked list:");
            while (cur != null){
                System.out.print(cur.value + " ");
                cur = cur.next;
            }
        }
        System.out.println();
    }

}
