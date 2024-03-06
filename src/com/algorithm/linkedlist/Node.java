package com.algorithm.linkedlist;


public class Node {
    public int value;
    public Node next;
    public Node prev;
    public Node random;
    public Node(int value){
        this.value = value;
    }
    public Node(){}

    @Override
    public String toString() {
        return "value = " + value + "next = " + next + "random = " + random;
    }
}
