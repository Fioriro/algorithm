package com.algorithm.greedy.getmedian;

import java.util.PriorityQueue;

/**
 * This class provides a way to get the median of a stream of integers at any time.
 * It uses two heaps, a max heap to store the smaller half of the numbers and a min heap to store the larger half.
 * The top of the max heap represents the largest number in the smaller half, and the top of the min heap represents the smallest number in the larger half.
 * Therefore, the median can be easily calculated from the tops of the two heaps.
 */
public class GetMedian {
    // Max heap to store the smaller half of the numbers
    private PriorityQueue<Integer> bigHeap = new PriorityQueue<>((a, b) -> b - a);
    // Min heap to store the larger half of the numbers
    private PriorityQueue<Integer> smallHeap = new PriorityQueue<>();

    /**
     * Adds a number to the data stream and rebalances the heaps.
     *
     * @param num The number to be added.
     */
    public void addNum(int num) {
        // If the max heap is empty or the number is smaller than the top of the max heap, add it to the max heap
        if (bigHeap.isEmpty() || num < bigHeap.peek()) {
            bigHeap.add(num);
        } else {
            // Otherwise, add it to the min heap
            smallHeap.add(num);
        }

        // If the size difference between the two heaps is 2, move the top element from the heap with more elements to the other heap
        if (bigHeap.size() - smallHeap.size() == 2) {
            smallHeap.add(bigHeap.poll());
        } else if (smallHeap.size() - bigHeap.size() == 2) {
            bigHeap.add(smallHeap.poll());
        }
    }

    /**
     * Returns the median of the current numbers in the data stream.
     *
     * @return The median of the current numbers.
     */
    public double findMedian() {
        // If the sizes of the two heaps are equal, the median is the average of the tops of the two heaps
        if (bigHeap.size() == smallHeap.size()) {
            return (bigHeap.peek() + smallHeap.peek()) / 2.0;
        } else if (bigHeap.size() > smallHeap.size()) {
            // If the max heap has more elements, the median is the top of the max heap
            return bigHeap.peek();
        } else {
            // If the min heap has more elements, the median is the top of the min heap
            return smallHeap.peek();
        }
    }
}