package com.algorithm.sort_algorithm.merge_sort;

import com.algorithm.utils.ArrayUtil;

/**
 * @author Fioriro
 * @version 1.0
 * 归并排序的扩展
 * 逆序对问题：
 * 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对
 * 请打印所有逆序对的数量；
 */
public class ReverseOrderNum {
    public static int reverseOrderNum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) //左侧排序完的逆序对数量
                + process(arr, mid + 1, R) //右侧排序完的逆序对数量
                + merge(arr, L, mid, R);//左右合并时的逆序对数量
    }

    public static int merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R){
            res += arr[p1] > arr[p2] ? (M - p1 + 1) : 0;//merge过程中产生逆序对的数量
            //如果左右的元素相等，应该先让左边的元素加入辅助数组
            //然后左边数组的指针就会向后移
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] arr = {3, 2, 4, 5, 0};
        int[] arr = ArrayUtil.randomArray(5,10);
        ArrayUtil.traverseArray(arr);
        int res = reverseOrderNum(arr);
        System.out.println(res);
    }
}
