package com.algorithm.sort_algorithm.merge_sort;

import com.algorithm.utils.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

public class SmallSumArray01 {
    public static List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length - 1, res);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < res.length; i++) {
            list.add(res[i]);
        }
        return list;
    }

    public static void mergeSort(int[] nums, int[] index, int L, int R, int[] res) {
        if (L >= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSort(nums, index, L, mid, res);
        mergeSort(nums, index, mid + 1, R, res);
        merge(nums, index, L, mid, mid + 1, R, res);
    }

    public static void merge(int[] nums, int[] index, int L1, int R1, int L2, int R2, int[] res) {
        int start = L1;
        int[] tmp = new int[R2 - L1 + 1];
        //记录逆序对数
        int count = 0;
        //temp数组的下标值
        int p = 0;
        while (L1 <= R1 || L2 <= R2) {
            //左边数组遍历结束后，将右边剩余的值放到temp数组中
            if (L1 > R1) {
                tmp[p++] = index[L2++];
            } else if (L2 > R2) {//右边数组遍历结束后，将左边剩余的值放到temp数组中
                //L1 是原数组索引值，index[L1]是排序好的原数组中索引值。
                //res[index[L1]] 对应的原数组索引位置赋逆变数
                res[index[L1]] += count;
                tmp[p++] = index[L1++];
            } else if (nums[index[L1]] > nums[index[L2]]) {
                tmp[p++] = index[L2++];
                count++;
            } else {
                //res存放每个数的最大值
                res[index[L1]] += count;
                tmp[p++] = index[L1++];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            //根据数组值排序，将对应的索引值放到index数组中
            index[start + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        ArrayUtil.traverseArray(arr);
        List<Integer> list = countSmaller(arr);
        System.out.println(list);
    }

}
