package com.algorithm.linkedlist.common_part;

import com.algorithm.linkedlist.Node;
import com.algorithm.linkedlist.singly.SinglyLinkedList;

import java.lang.reflect.Array;

public class LinkedListCommonPart {

    public static void main(String[] args) {
        // construct two linked lists
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        // add different nodes to the two linked list
        for (int i = 1; i <= 5; i++) {
            SinglyLinkedList.insertTail(list1, i);
            SinglyLinkedList.insertTail(list2, i + 5);
        }

        // construct a linked list with some new nodes, making it a common part of a linked list
        SinglyLinkedList commonList = new SinglyLinkedList();
        for (int i = 11; i <= 15; i++) {
            SinglyLinkedList.insertTail(commonList, i);
        }

        // connect list1 and list2's tail to commonList
        Node tail1 = list1.head;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        tail1.next = commonList.head;

        Node tail2 = list2.head;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        tail2.next = commonList.head;

        SinglyLinkedList.traverse(list1);
        SinglyLinkedList.traverse(list2);

        printCommonPart(list1, list2);

    }

    public static void printCommonPart(SinglyLinkedList list1, SinglyLinkedList list2){
        Node cur1 = list1.head;
        Node cur2 = list2.head;
        if(list1 == null || list1.head == null || list2 == null || list2.head == null){
            System.out.println("Singly linked list is empty!");
            return;
        }
        while (cur1 != null && cur2 != null){
            if(cur1.value == cur2.value){
                System.out.println(cur1.value);
                cur1 = cur1.next;
                cur2 = cur2.next;
            }else if(cur1.value < cur2.value){
                cur1 = cur1.next;
            }else {
                cur2 = cur2.next;
            }
        }
    }
}
