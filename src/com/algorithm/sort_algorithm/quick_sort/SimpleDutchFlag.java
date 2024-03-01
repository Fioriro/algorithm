package com.algorithm.sort_algorithm.quick_sort;

import com.algorithm.array_util.ArrayUtil;

public class SimpleDutchFlag {

    public static void simpleDutchFlag(int[] arr, int X){
        int L = -1;
        int R = arr.length;
        int index = 0;

        while (index < R){
            if (arr[index] < X){
                //小于给定的数时，当前位置的数和小于区后一位交换，然后小于区扩大
                ArrayUtil.swap(arr, index++, ++L);
            } else if (arr[index] == X) {
                //等于给定的数时，当前位置直接后移
                index++;
            } else {
                //大于给定的数时，当前位置的数和大于区前一位交换，然后大于区扩大，但是当前位置不变
                ArrayUtil.swap(arr, index, --R);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(50, 20);
        int X =arr[(int)(Math.random() * 50)];
        ArrayUtil.traverseArray(arr);
        System.out.println(X);
        simpleDutchFlag(arr, X);
        ArrayUtil.traverseArray(arr);
    }
}
