package com.algorithm.utils;

import com.algorithm.tree.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static Node generateTreeBFS(String bfs) {
        String[] values = bfs.split(",");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i += 2) {
            Node parent = queue.poll();
            if (!values[i].equals("null")) {
                parent.left = new Node(Integer.parseInt(values[i]));
                queue.add(parent.left);
            }
            if (i + 1 < values.length && !values[i + 1].equals("null")) {
                parent.right = new Node(Integer.parseInt(values[i + 1]));
                queue.add(parent.right);
            }
        }
        return root;
    }

    public static Node generateTreePre(String preOrder) {
        String[] values = preOrder.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return generatePreOrder(queue);
    }

    private static Node generatePreOrder(Queue<String> queue) {
        String value = queue.poll().trim();
        if (value.equals("null")) {
            return null;
        }
        Node node = new Node(Integer.parseInt(value));
        node.left = generatePreOrder(queue);
        node.right = generatePreOrder(queue);
        return node;
    }
}
