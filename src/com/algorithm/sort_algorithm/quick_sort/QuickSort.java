package com.algorithm.sort_algorithm.quick_sort;

import com.algorithm.utils.ArrayUtil;

/**
 * @author Fioriro
 * @version 1.0
 * 快速排序
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num,请把小于num的数放在数组的左边，
 * 等于num的数放在数组的中间，大于num的数放在数组的右边/
 * 要求额外空间复杂度O(1),时间复杂度O(N)
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R){
        if(L < R){
            //数组中随便一个数作为划分值，和数组最后一个数交换
            ArrayUtil.swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);// < 区
            quickSort(arr, p[1] + 1, R);// > 区
        }
    }

    //这是一个处理arr[L...R]的函数
    //默认以arr[R]做划分，arr[R] -> p  <p   ==p   >p
    //返回等于区域（左边界，右边界），所以返回一个长度为2的数组res,res[0] res[1]
    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1;//<区右边界
        int more = R;//>区左边界
        //确定小于区，等于区，大于区
        while (L < more){//L表示当前数的位置 arr[R] -> 划分值
            if(arr[L] < arr[R]){//当前数 < 划分值
                ArrayUtil.swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {//当前数 > 划分值
                ArrayUtil.swap(arr, --more, L);
            }else {
                L++;
            }
        }
        //大于区左边界的数和R交换
        ArrayUtil.swap(arr, more, R);
        return new int[] {less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10,10);
        ArrayUtil.traverseArray(arr);
        quickSort(arr);
        ArrayUtil.traverseArray(arr);
    }
}
