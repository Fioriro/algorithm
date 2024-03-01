package com.algorithm.sort_algorithm.selection_sort;

import com.algorithm.utils.ArrayUtil;

public class SelectionSort {

    /**
     * Start from the first element in the array, assume this item is the smallest.
     * Then, for each subsequent item in the array, compare it with the current smallest item.
     * If you find an item that is smaller than the current smallest item, update your smallest item.
     * Once you've checked all items in the array, swap the first item with the smallest item you found.
     * Move to the next element in the array and repeat the process until you've gone through all the elements in the array.
     *
     * @param arr int[] arr
     */
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayUtil.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        ArrayUtil.traverseArray(arr);
        selectionSort(arr);
        ArrayUtil.traverseArray(arr);
    }
}
