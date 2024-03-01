package com.algorithm.linkedlist.singly;

import com.algorithm.linkedlist.Node;
import com.algorithm.utils.ArrayUtil;
import com.algorithm.utils.LinkedListUtil;

public class SinglyLinkedList {

    Node head;

    // Method to insert a new node
    public static SinglyLinkedList insert(SinglyLinkedList list, int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
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

    public static void traverse(SinglyLinkedList list){
        if (list.head.next == null){
            System.out.println("this singly linked list is empty!");
        }
        Node cur = list.head;
        System.out.println("singly linked list: ");
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        ArrayUtil.traverseArray(arr);
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i : arr) {
            insert(list, i);
        }
        traverse(list);
    }
}
