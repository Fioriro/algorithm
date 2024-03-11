package com.algorithm.utils;

import com.algorithm.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static Node generateTree(String bfs) {
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
}
