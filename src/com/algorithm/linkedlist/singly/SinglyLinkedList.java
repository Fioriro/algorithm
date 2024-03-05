package com.algorithm.linkedlist.singly;

import com.algorithm.linkedlist.Node;
import com.algorithm.utils.ArrayUtil;

import java.util.List;
import java.util.function.IntFunction;

public class SinglyLinkedList {

    public Node head;

    // Method to insert a new node to tail
    public static SinglyLinkedList insertTail(SinglyLinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    //method to insert a new node to head
    public static void insertHead(SinglyLinkedList list, int data){
        Node newNode = new Node(data);
        if(list.head == null){
            list.head = newNode;
        } else {
            newNode.next = list.head;
            list.head = newNode;
        }
    }

    //method to traverse linked list
    public static void traverse(SinglyLinkedList list) {
        if (list.head.next == null) {
            System.out.println("this singly linked list is empty!");
        }
        Node cur = list.head;
        System.out.println("singly linked list: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //method to delete a node by its value
    public static void deleteByValue(SinglyLinkedList list, int value){
        if(list == null || list.head == null){
            System.out.println("singly linked list is null!");
            return;
        }
        Node cur = list.head;
        if(cur.value == value){
            list.head = cur.next;
            System.out.println("Node delete successfully!");
            return;
        }
        while (cur.next != null && cur.next.value != value){
            cur = cur.next;
        }
        if(cur.next != null){
            cur.next = cur.next.next;
            System.out.println("Node delete successfully!");
        }else {
            System.out.println("No such node in linked list!");
        }
    }

    //reverse a linked list
    public static void reverseLinkedList(SinglyLinkedList list){
        if(list == null || list.head == null){
            System.out.println("singly linked list is null!");
            return;
        }
        Node cur = list.head;
        Node next = null;
        Node prev = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        list.head = prev;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayUtil.traverseArray(arr);
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i : arr) {
            //insertTail(list, i);
            insertHead(list, i);
        }
        traverse(list);
        //deleteByValue(list, 11);
        reverseLinkedList(list);
        traverse(list);
    }
}
