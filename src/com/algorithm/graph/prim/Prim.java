package com.algorithm.graph.prim;

import com.algorithm.graph.Edge;
import com.algorithm.graph.Graph;
import com.algorithm.graph.Node;
import com.algorithm.graph.traverse.BFS.GraphBFS;

import java.util.*;

public class Prim {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        graph.nodes.put(1, node1);
        graph.nodes.put(2, node2);
        graph.nodes.put(3, node3);
        graph.nodes.put(4, node4);
        graph.nodes.put(5, node5);

        Edge edge1 = new Edge(7, node1, node2);
        node1.edges.add(edge1);
        node2.edges.add(edge1);
        Edge edge2 = new Edge(2, node1, node3);
        node1.edges.add(edge2);
        node3.edges.add(edge2);
        Edge edge3 = new Edge(4, node3, node4);
        node3.edges.add(edge3);
        node4.edges.add(edge3);
        Edge edge4 = new Edge(100, node1, node4);
        node1.edges.add(edge4);
        node4.edges.add(edge4);
        Edge edge5 = new Edge(1000, node2, node4);
        node4.edges.add(edge5);
        node2.edges.add(edge5);
        Edge edge6 = new Edge(10000, node2, node5);
        node5.edges.add(edge6);
        node2.edges.add(edge6);
        Edge edge7 = new Edge(7, node2, node1);
        node1.edges.add(edge7);
        node2.edges.add(edge7);
        Edge edge8 = new Edge(2, node3, node1);
        node1.edges.add(edge8);
        node3.edges.add(edge8);
        Edge edge9 = new Edge(4, node4, node3);
        node3.edges.add(edge9);
        node4.edges.add(edge9);
        Edge edge10 = new Edge(100, node4, node1);
        node1.edges.add(edge10);
        node4.edges.add(edge10);
        Edge edge11 = new Edge(1000, node4, node2);
        node4.edges.add(edge11);
        node2.edges.add(edge11);
        Edge edge12 = new Edge(10000, node5, node2);
        node5.edges.add(edge12);
        node2.edges.add(edge12);

        graph.edges.add(edge1);
        graph.edges.add(edge2);
        graph.edges.add(edge3);
        graph.edges.add(edge4);
        graph.edges.add(edge5);
        graph.edges.add(edge6);
        graph.edges.add(edge7);
        graph.edges.add(edge8);
        graph.edges.add(edge9);
        graph.edges.add(edge10);
        graph.edges.add(edge11);
        graph.edges.add(edge12);


        Set<Edge> prim = prim(graph);
        for (Edge edge : prim) {
            System.out.println(edge);
        }

    }

    /**
     * add the minimum-weight edge that connects a node in the MST
     * to a node outside the MST
     * @param graph
     * @return
     */
    public static Set<Edge> prim(Graph graph){
        //store all the unlocked edge
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        //indicate whether a node is already in MST
        HashSet<Node> set = new HashSet<>();
        //result set
        HashSet<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) {// select a random node
            if(!set.contains(node)){
                set.add(node);
                //the newly added node's adjacent edges will be added to the queue
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();//the minimum edge in unlocked edges
                    Node toNode = edge.to; // a probably new node
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        //the toNode expand the MST, then add all the edges which connected MST and other node
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }
}
