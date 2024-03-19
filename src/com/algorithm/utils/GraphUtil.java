package com.algorithm.utils;

import com.algorithm.graph.Edge;
import com.algorithm.graph.Graph;
import com.algorithm.graph.Node;

import java.util.Arrays;

public class GraphUtil {

    public static Graph initializeGraph(int[][] matrix) {
        Graph graph = new Graph();
        for(int i = 0; i < matrix.length; i++){
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

    public static void printGraphMatrix(Graph graph) {
        int size = graph.nodes.size();
        int[][] matrix = new int[size][size];
        int infinity = Integer.MAX_VALUE; // Special value to represent "∞"

        // Initialize the matrix with the special value
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], infinity);
        }

        // Populate the matrix with the weights of the edges
        for (Node node : graph.nodes.values()) {
            for (Edge edge : node.edges) {
                int fromIndex = edge.from.value - 1;
                int toIndex = edge.to.value - 1;
                matrix[fromIndex][toIndex] = edge.weight;
            }
        }

        // Print the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == infinity) {
                    if(i == j){
                        System.out.print(0 + " ");
                    }else {
                        System.out.print("∞ ");
                    }
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
