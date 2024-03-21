package com.algorithm.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {
    private Map<Node, Node> parentMap;
    private Map<Node, Integer> rankMap;

    public UnionFind() {
        parentMap = new HashMap<>();
        rankMap = new HashMap<>();
    }

    public void makeSets(Collection<Node> nodes) {
        for (Node node : nodes) {
            parentMap.put(node, node);
            rankMap.put(node, 1);
        }
    }

    private Node find(Node node) {
        Node parent = parentMap.get(node);
        if (node != parent) {
            parent = find(parent);
        }
        parentMap.put(node, parent);
        return parent;
    }

    public boolean isSameSet(Node node1, Node node2) {
        return find(node1) == find(node2);
    }

    public void union(Node node1, Node node2) {
        Node parent1 = find(node1);
        Node parent2 = find(node2);
        if (parent1 != parent2) {
            int rank1 = rankMap.get(parent1);
            int rank2 = rankMap.get(parent2);
            if (rank1 > rank2) {
                parentMap.put(parent2, parent1);
            } else if (rank1 < rank2) {
                parentMap.put(parent1, parent2);
            } else {
                parentMap.put(parent2, parent1);
                rankMap.put(parent1, rank1 + 1);
            }
        }
    }
}
