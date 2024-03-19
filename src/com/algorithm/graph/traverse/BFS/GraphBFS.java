package com.algorithm.graph.traverse.BFS;

import com.algorithm.graph.Graph;
import com.algorithm.graph.Node;
import com.algorithm.utils.GraphUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphBFS {

    public static void main(String[] args) {
        int[][] table = {
                {1,3,7},
                {1,4,3},
                {2,3,2},
                {3,4,5},
                {3,1,7},
                {4,1,3},
                {3,2,2},
                {4,3,5}
        };

        int[][] table1 = {
                {1,2,0},
                {1,3,0},
                {1,5,0},
                {2,3,0},
                {3,5,0},
                {3,4,0},
                {4,5,0},
                {2,1,0},
                {3,1,0},
                {5,1,0},
                {3,2,0},
                {5,3,0},
                {4,3,0},
                {5,4,0},
        };

        int[][] matrix = {
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5},
                {4, 1, 6}
        };

        // Initialize the graph
        Graph graph = GraphUtil.initializeGraph(matrix);

        // Print the graph matrix
        GraphUtil.printGraphMatrix(graph);

//        Graph graph1 = GraphUtil.initializeGraph(table1);
//        GraphUtil.printGraphMatrix(graph1);

//        Graph graph = GraphUtil.initializeGraph(table);
//        GraphUtil.printGraphMatrix(graph);

        //graphBFS(graph.nodes.get(3));
        graphDFS(graph.nodes.get(1));
    }

    public static void graphBFS(Node start){
        if(start == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp);
            for (Node next : temp.nexts) {
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    public static void graphDFS(Node start){
        if(start == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(start);
        set.add(start);
        System.out.println(start);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            for (Node next : temp.nexts) {
                if(!set.contains(next)){
                    stack.push(temp);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next);
                    break;
                }
            }
        }
    }
}
