package com.algorithm.tree.traverse.BFS.max_width;

import com.algorithm.tree.Node;
import com.algorithm.tree.traverse.BFS.BFS;
import com.algorithm.utils.TreeUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GetMaxWidth {

    public static void main(String[] args) {
        String bfs = "1,2,3,4,5,6,null,null,null,7,null,null,8";
        Node root = TreeUtil.generateTree(bfs);
        BFS.BFS(root);
        System.out.println();
        System.out.println("max width: " + getMaxWidth(root));
    }

    public static int getMaxWidth(Node root) {
        if (root == null) {
            return 0;
        }
        int curLevel = 1;
        int Nodes = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, 1);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = map.get(cur);
            if (curNodeLevel == curLevel) {
                Nodes++;
            } else {
                max = Math.max(max, Nodes);
                curLevel++;
                Nodes = 1;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, curNodeLevel + 1);

            }
            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, curNodeLevel + 1);
            }

        }
        return max;
    }
}
