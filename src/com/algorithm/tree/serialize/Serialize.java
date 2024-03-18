package com.algorithm.tree.serialize;

import com.algorithm.tree.Node;
import com.algorithm.tree.traverse.preorder.Preorder;
import com.algorithm.utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize {

    public static void main(String[] args) {
        String str = "1, null, 1, 1, null, null, null";
        Node head = TreeUtil.generateTreePre(str);
        String s = serialByPre(head);
        System.out.println(s);
        Node node = reconByPreString(s);
        Preorder.preorder(node);
    }

    static String serialByPre(Node head){
        if(head == null){
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
