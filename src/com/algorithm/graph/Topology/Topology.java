package com.algorithm.graph.Topology;

import com.algorithm.graph.Edge;
import com.algorithm.graph.Graph;
import com.algorithm.graph.Node;

import java.util.*;

public class Topology {
    public static void main(String[] args) {
        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

// Create edges and connect nodes
        Edge edge1 = new Edge(3, node1, node2);
        Edge edge2 = new Edge(4, node2, node3);
        Edge edge3 = new Edge(5, node3, node4);
        Edge edge4 = new Edge(6, node4, node1);

// Add edges to nodes
        node1.edges.add(edge1);
        node2.edges.add(edge2);
        node3.edges.add(edge3);
        node4.edges.add(edge4);

// Add next nodes
        node1.nexts.add(node2);
        node2.nexts.add(node3);
        node3.nexts.add(node4);
        node4.nexts.add(node1);

// Update in and out degrees
        node1.out++;
        node2.in++;
        node2.out++;
        node3.in++;
        node3.out++;
        node4.in++;
        node4.out++;

        Graph graph = new Graph();
        graph.nodes.put(node1.value, node1);
        graph.nodes.put(node2.value, node2);
        graph.nodes.put(node3.value, node3);
        graph.nodes.put(node4.value, node4);

        graph.edges.add(edge1);
        graph.edges.add(edge2);
        graph.edges.add(edge3);
        graph.edges.add(edge4);


        List<Node> list = topology(graph);
        System.out.println(list);
    }

    public static List<Node> topology(Graph graph) {
        // key: a specify node
        // value: the rest of in-degree
        HashMap<Node, Integer> inMap = new HashMap<>();
        // only a node's in-degree is 0 can enqueue
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        // add the result of topology sort to the result list
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

}
