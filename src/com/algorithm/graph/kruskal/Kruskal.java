package com.algorithm.graph.kruskal;

import com.algorithm.graph.Edge;
import com.algorithm.graph.Graph;
import com.algorithm.graph.Node;
import com.algorithm.graph.UnionFind;
import com.algorithm.graph.traverse.BFS.GraphBFS;

import java.util.*;
import java.util.stream.Collectors;

public class Kruskal {
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
        Edge edge2 = new Edge(2, node1, node3);
        Edge edge3 = new Edge(4, node3, node4);
        Edge edge4 = new Edge(100, node1, node4);
        Edge edge5 = new Edge(1000, node2, node4);
        Edge edge6 = new Edge(10000, node2, node5);
        Edge edge7 = new Edge(7, node2, node1);
        Edge edge8 = new Edge(2, node3, node1);
        Edge edge9 = new Edge(4, node4, node3);
        Edge edge10 = new Edge(100, node4, node1);
        Edge edge11 = new Edge(1000, node4, node2);
        Edge edge12 = new Edge(10000, node5, node2);

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


        Set<Edge> kruskal = kruskal(graph);
        for (Edge edge : kruskal) {
            System.out.println(edge);
        }
    }

    public static Set<Edge> kruskal(Graph graph){
       UnionFind unionFind = new UnionFind();
       unionFind.makeSets(graph.nodes.values());
       PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
           @Override
           public int compare(Edge o1, Edge o2) {
               return o1.weight - o2.weight;
           }
       });
        priorityQueue.addAll(graph.edges);
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from, edge.to)){
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }


}
