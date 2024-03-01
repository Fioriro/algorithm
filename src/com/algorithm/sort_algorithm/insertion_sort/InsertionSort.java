package com.algorithm.sort_algorithm.insertion_sort;

import com.algorithm.utils.ArrayUtil;

public class InsertionSort {

    /**
     * Start from the second element in the array (index 1), as the first element is considered sorted.
     * For each element, compare it with the elements before it in the array.
     * If the current element is smaller than the previous element, swap them.
     * Continue this process, moving backwards through the array until you find an element that is smaller than the current element or you reach the beginning of the array.
     * Repeat this process for all elements in the array.
     *
     * @param arr an integer array
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i -1; j >= 0; j--){
                if (arr[j] > arr[j+1]){
                    ArrayUtil.swap(arr, j, j+1);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        ArrayUtil.traverseArray(arr);
        insertionSort(arr);
        ArrayUtil.traverseArray(arr);
    }
}
