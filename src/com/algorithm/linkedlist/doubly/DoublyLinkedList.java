package com.algorithm.linkedlist.doubly;

import com.algorithm.linkedlist.Node;
import com.algorithm.linkedlist.singly.SinglyLinkedList;
import com.algorithm.utils.ArrayUtil;

public class DoublyLinkedList {

    Node head;
    Node tail;

    //method to insert a new node to head
    public static void insertHead(DoublyLinkedList list, int data){
        Node newNode = new Node(data);
        if(list.head == null && list.tail == null){
            list.head = newNode;
            list.tail = newNode;
        }else {
            newNode.next = list.head;
            list.head.prev = newNode;
            list.head = newNode;
        }
    }

    //method to insert a new node to tail
    public static void insertTail(DoublyLinkedList list, int data){
        Node newNode = new Node(data);
        if(list.head == null && list.tail == null){
            list.head = newNode;
            list.tail = newNode;
        }else{
            newNode.prev = list.tail;
            list.tail.next = newNode;
            list.tail = newNode;
        }
    }

    //method to delete a node by its value
    /**
     * This method deletes a node from a doubly linked list by its value.
     *
     * @param list  The doubly linked list from which the node will be deleted.
     * @param value The value of the node to be deleted.
     */
    public static void deleteByValue(DoublyLinkedList list, int value){
        // Check if the list is null or empty. If so, print a message and return.
        if (list == null || list.head == null){
            System.out.println("doubly linked list is empty!");
            return;
        }
        // Start from the head of the list.
        Node cur = list.head;
        // Traverse the list until the end or until a node with the given value is found.
        while (cur != null && cur.value != value){
            cur = cur.next;
        }
        // If a node with the given value is found.
        if(cur != null){
            // If the node is not the head, update the next pointer of the previous node.
            if(cur.prev != null) {
                cur.prev.next = cur.next;
            }
            // If the node is not the tail, update the prev pointer of the next node.
            if(cur.next != null) {
                cur.next.prev = cur.prev;
            }
            // If the node is the head, update the head of the list.
            if(cur == list.head) {
                list.head = cur.next;
            }
            // If the node is the tail, update the tail of the list.
            if(cur == list.tail) {
                list.tail = cur.prev;
            }
            // Print a success message.
            System.out.println("Node delete successfully!");
        } else {
            // If no node with the given value is found, print a message.
            System.out.println("No such node in linked list!");
        }
    }

    //method to traverse linked list from head
    public static void traverseHead(DoublyLinkedList list) {
        if (list.head == null) {
            System.out.println("this doubly linked list is empty!");
            return;
        }
        Node cur = list.head;
        System.out.println("traversing doubly linked list from head: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //method to traverse linked list from tail
    public static void traverseTail(DoublyLinkedList list){
        if (list.head == null && list.tail == null) {
            System.out.println("this doubly linked list is empty!");
            return;
        }
        Node cur = list.tail;
        System.out.println("traversing doubly linked list from tail:");
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayUtil.traverseArray(arr);
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i : arr) {
            //insertHead(list, i);
            insertTail(list, i);
        }
        deleteByValue(list, 1);
        traverseHead(list);
        traverseTail(list);
    }

}
