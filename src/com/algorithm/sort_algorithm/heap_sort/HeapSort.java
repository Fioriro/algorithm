package com.algorithm.sort_algorithm.heap_sort;

import com.algorithm.utils.ArrayUtil;

public class HeapSort {

    //将数组调整为大根堆
    //新插入节点比父节点大，交换此节点和父节点，然后继续判断
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            ArrayUtil.swap(arr, index, ((index - 1) / 2));
            index = ((index - 1) / 2);
        }
    }


    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;//left child

        while (left < heapSize){
            //两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize  && arr[left + 1] > arr[left] ? left + 1 : left;
            //父和孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            ArrayUtil.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //将数组调整为大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        //因为是大根堆，所以根节点是数组中最大的数
        //将这个数和堆大小前面一位进行交换，
        //即堆中的最大值已确定，弹出这个数，同时堆大小减小
        ArrayUtil.swap(arr, 0, --heapSize);
        //循环进行
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            ArrayUtil.swap(arr, 0, --heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        ArrayUtil.traverseArray(arr);
        heapSort(arr);
        ArrayUtil.traverseArray(arr);
    }
}
