package com.algorithm.sort_algorithm.merge_sort;


public class SmallSum01 {
    /**
     * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
     * 数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     * 示例 1：
     *
     * 输入：nums = [5,2,6,1]
     * 输出：[2,1,1,0]
     * 解释：
     * 5 的右侧有 2 个更小的元素 (2 和 1)
     * 2 的右侧仅有 1 个更小的元素 (1)
     * 6 的右侧有 1 个更小的元素 (1)
     * 1 的右侧有 0 个更小的元素
     * 示例 2：
     *
     * 输入：nums = [-1]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：nums = [-1,-1]
     * 输出：[0,0]
     */



    public static int smallSum(int[] arr, int L, int R, int res){
        if (L == R){
            return res;
        }
        int M = L + ((R-L)>>1);
        res = smallSum(arr, L ,M, res) + smallSum(arr, M + 1, R, res) + merge(arr, L, M, R, res);
        return res;
    }

    public static int merge(int[] arr, int L, int M, int R, int res){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R){
            if (arr[p1] <= arr[p2]){
                res += (R - p2 + 1) * arr[p1];
                help[i++] = arr[p1++];
            }else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= M){
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
        //int[] arr = {2, 4, 5, 1, 7, 3}; //23
        int[] arr = {1, 3, 4, 2, 5};//16
        System.out.println(smallSum(arr, 0, arr.length - 1, 0));
    }
}
