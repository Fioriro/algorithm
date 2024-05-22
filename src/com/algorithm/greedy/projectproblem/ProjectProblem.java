package com.algorithm.greedy.projectproblem;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This class represents a project problem where the goal is to find the maximum capital.
 */
public class ProjectProblem {

    /**
     * This class represents a node with profit and cost.
     */
    public static class Node{
        public int profit;
        public int cost;

        /**
         * Constructs a new Node with the given profit and cost.
         *
         * @param profit The profit of the node.
         * @param cost The cost of the node.
         */
        public Node(int profit, int cost){
            this.profit = profit;
            this.cost = cost;
        }
    }

    /**
     * This class compares two nodes based on their cost.
     */
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    /**
     * This class compares two nodes based on their profit.
     */
    public static class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    /**
     * This method finds the maximum capital that can be achieved with the given profits and costs.
     *
     * @param k The number of projects that can be selected.
     * @param w The initial capital.
     * @param Profits The array of profits for each project.
     * @param Costs The array of costs for each project.
     * @return The maximum capital that can be achieved.
     */
    public static int findMaximizedCapital(int k, int w, int[] Profits, int[] Costs){
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i], Costs[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= w){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return w;
            }
            w += maxProfitQ.poll().profit;
        }
        return w;
    }
}