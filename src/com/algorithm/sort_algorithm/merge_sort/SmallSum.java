package com.algorithm.sort_algorithm.merge_sort;

import com.algorithm.array_util.ArrayUtil;


/**
 * @author Fioriro
 * @version 1.0
 * 归并排序的拓展
 * 小和问题和逆序对问题
 * 1.小和问题：
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个小和
 * 例子：[1,3,4,2,5]，1左边比1小的数，没有；3左边比3小的数，1；
 * 4左边比4小的数，1，3；2左边比2小的数，1；5左边比5小的数，1，3，4，2；
 * 所以小和为 1 + 1 + 3 + 1 + 1 + 3 + 4 + 2 = 16
 *
 */
public class SmallSum {

    //暴力求解 O(N^2)
    public static int smallSumForce(int[] arr){
        if(arr == null || arr.length < 2){
            return -1;
        }
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    sum += arr[j];
                }
            }

        }
        return sum;
    }


    //改写mergeSort (N*logN)
    public static int smallSum(int[] arr){
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
        return process(arr, L, mid) //左侧排序完的小和
                + process(arr, mid + 1, R) //右侧排序完的小和
                + merge(arr, L, mid, R);//左右合并时的小和
    }

    public static int merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R){
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;//merge过程中产生小和
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        //int[] arr = {1, 3, 4, 2, 5};
//        int[] arr = ArrayUtil.randomArray(5, 10);
//        ArrayUtil.traverseArray(arr);
//        int res = MinSumForce(arr);
        int[] arr = ArrayUtil.randomArray(10,10);
        //int[] arr = {1, 3, 4, 2, 5};
        ArrayUtil.traverseArray(arr);
        int res = smallSum(arr);
        System.out.println(res);
    }
}
