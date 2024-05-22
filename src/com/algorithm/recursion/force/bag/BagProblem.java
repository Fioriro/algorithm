package com.algorithm.recursion.force.bag;

public class BagProblem {


    public static int process(int bag, int[] weights, int[] values, int i, int alreadyWeight, int alreadyValue){
        if(alreadyWeight > bag){
            return 0;
        }
        if(i == values.length){
            return alreadyValue;
        }
        return Math.max(process(bag, weights, values, i + 1, alreadyWeight, alreadyValue),
                process(bag, weights, values, i + 1,
                        alreadyWeight + weights[i], alreadyValue + values[i]));
    }

    public static void main(String[] args) {
        // Test case 1: Normal case with multiple items and a bag that can hold some of them
        int[] weights1 = {1, 2, 3, 4, 5};
        int[] values1 = {5, 4, 3, 2, 1};
        int bag1 = 5;
        System.out.println(process(bag1, weights1, values1, 0, 0, 0)); // Expected output: 9

        // Test case 2: Normal case with multiple items and a bag that can hold all of them
        int[] weights2 = {1, 2, 3};
        int[] values2 = {3, 2, 1};
        int bag2 = 6;
        System.out.println(process(bag2, weights2, values2, 0, 0, 0)); // Expected output: 6

        // Test case 3: Edge case with an empty bag
        int[] weights3 = {1, 2, 3, 4, 5};
        int[] values3 = {5, 4, 3, 2, 1};
        int bag3 = 0;
        System.out.println(process(bag3, weights3, values3, 0, 0, 0)); // Expected output: 0

        // Test case 4: Edge case with no items
        int[] weights4 = {};
        int[] values4 = {};
        int bag4 = 5;
        System.out.println(process(bag4, weights4, values4, 0, 0, 0)); // Expected output: 0
    }
}
