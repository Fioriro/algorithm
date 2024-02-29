package com.algorithm.recursion;

import com.algorithm.array_util.ArrayUtil;

public class GetMaxByRecursion {

    //arr[L...R]范围上求最大值
    public static int process(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr,L,mid);
        int rightMax = process(arr,mid+1, R);
        return Math.max(leftMax,rightMax);
    }

    public static int getMax(int[] arr){
        return process(arr, 0 , arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        ArrayUtil.traverseArray(arr);
        System.out.println( getMax(arr));
    }
}
