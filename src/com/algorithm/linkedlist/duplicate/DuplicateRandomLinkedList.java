package com.algorithm.linkedlist.duplicate;

import com.algorithm.linkedlist.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateRandomLinkedList {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();


        // Step 1, 2: Create new nodes and set their values
        for (int i = 0; i < 5; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }

        // Step 3, 4: Set next and prev pointers
        for (int i = 0; i < nodes.size(); i++) {
            if (i != 0) {
                nodes.get(i).prev = nodes.get(i - 1);
            }
            if (i != nodes.size() - 1) {
                nodes.get(i).next = nodes.get(i + 1);
            }
        }

        // Step 5: Set random pointers to the next node
        for (int i = 0; i < nodes.size(); i++) {
            if (i != nodes.size() - 1) {
                nodes.get(i).random = nodes.get(i + 1);
            }
        }

        // Print the linked list to verify
        traverse(nodes);

        Node head = nodes.get(0);
        Node cur = head;
        while (cur != null) {
            System.out.print("value: " + cur.value);
            System.out.println("Random: " + (cur.random != null ? cur.random.value : "null"));
            System.out.println();
            cur = cur.next;
        }
        Node newHead = duplicate(head);
        cur = newHead;
        while (cur != null) {
            System.out.print("value: " + cur.value);
            System.out.println("Random: " + (cur.random != null ? cur.random.value : "null"));
            System.out.println();
            cur = cur.next;
        }
        

    }

    public static Node duplicate(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        Node duplicateHead = map.get(head);
        return duplicateHead;
    }

    static void traverse(List<Node> nodes){
        for (Node node : nodes) {
            System.out.println("Value: " + node.value);
            System.out.println("Next: " + (node.next != null ? node.next.value : "null"));
            System.out.println("Prev: " + (node.prev != null ? node.prev.value : "null"));
            System.out.println("Random: " + (node.random != null ? node.random.value : "null"));
            System.out.println();
        }
    }
}


