package com.algorithm.sort_algorithm.merge_sort;

import com.algorithm.array_util.ArrayUtil;

public class MergeSort02 {

    public static void mergeSort(int[] arr, int L, int R){
        if (L == R){
            return;
        }
        int M = L + ((R - L) >> 1);
        mergeSort(arr, L, M);
        mergeSort(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] arr, int L, int M, int R){
        //开辟辅助空间
        int[] help = new int[R - L + 1];
        //辅助指针
        int i = 0;
        //辅助指针
        int p1 = L;
        int p2 = M + 1;
        //当左右两边不越界时
        while (p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //当有一边越界时，将另一边全部打印
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        //全部拷贝完成后，将辅助数组的值赋给原数组
        for (int j = 0; j < help.length; j++) {
            arr[L+j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        ArrayUtil.traverseArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        ArrayUtil.traverseArray(arr);
    }
}
