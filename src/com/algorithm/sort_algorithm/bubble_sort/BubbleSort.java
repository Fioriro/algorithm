package com.algorithm.sort_algorithm.bubble_sort;

import com.algorithm.utils.ArrayUtil;

public class BubbleSort {

    /**
     * 冒泡排序，外层循环确定轮数，内层循环进行排序
     * @param arr 传入的整型数组
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    ArrayUtil.swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 10);
        ArrayUtil.traverseArray(arr);
        bubbleSort(arr);
        ArrayUtil.traverseArray(arr);
    }
}
