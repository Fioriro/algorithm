package com.algorithm.linkedlist.circle;

import com.algorithm.linkedlist.Node;
import com.algorithm.linkedlist.singly.SinglyLinkedList;

public class SinglyLinkedListCircle {


    public static void main(String[] args) {
        // Create a singly linked list
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert nodes into the list
        for (int i = 1; i <= 5; i++) {
            SinglyLinkedList.insertTail(list, i);
        }

        // Create a circle in the list
        SinglyLinkedList.createCircle(list, 2); // This will create a circle at the 2nd node



        Node res = circle(list.head);
        System.out.println(res == null ? "null" : res);
    }



    static Node circle(Node head){
        if(head == null || head.next == null){
            System.out.println("Singly linked list is empty!");
            return null;
        }

        Node s = head;
        Node f = head;
        boolean flag = false;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                flag = true;
                break;
            }
        }
        if(!flag) return null;

        f = head;
        while (f != s){
            s = s.next;
            f = f.next;
        }
        return f;
    }
}
