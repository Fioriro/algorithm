package com.algorithm.linkedlist.lc234_palindrome_linked_list;

import com.algorithm.linkedlist.Node;

import java.util.Stack;

public class lc234_palindrome_linked_list_01 {

    public static boolean solution1(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        if (head == null) {
            return false;
        }
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean solution2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {// find mid node
            n1 = n1.next;// n1 -> mid
            n2 = n2.next.next;// n2 -> end
        }
        n2 = n1.next;// n2 -> right part first node
        n1.next = null;// mid.next -> null
        Node n3 = null;
        while (n2 != null) {// right part convert
            n3 = n2.next;// n3 -> save next node
            n2.next = n1;// next of right node convert
            n1 = n2;// n1 move
            n2 = n3;// n2 move
        }
        n3 = n1; // n3 -> save last node
        n2 = head; // n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next;// right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {// recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
