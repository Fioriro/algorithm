package com.algorithm.array_util;

/**
 * @author Fioriro
 * @version 1.0
 */
public class ArrayUtil {
    public static int[] randomArray(int size, int max){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)((Math.random() * max) + 1);
        }
        return arr;
    }

    public static void traverseArray(int[] arr){
        System.out.println("当前数组中的元素是：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void  swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


