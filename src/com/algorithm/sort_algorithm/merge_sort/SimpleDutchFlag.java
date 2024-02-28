package com.algorithm.sort_algorithm.merge_sort;

import com.algorithm.array_util.ArrayUtil;

public class SimpleDutchFlag {

    public static void simpleDutchFlag(int[] arr, int X){
        int L = -1;
        int R = arr.length - 1;
        int index = 1;

        while (index < R){
            if (arr[index] < X){
                ArrayUtil.swap(arr, index++, ++L);
            }
        }
    }

    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        // 小于arr[r]的右边界，从L的左边一位开始
        int less = l - 1;
        // 大于arr[r]的左边界，从r开始，即当前右边界里已经有arr[r]
        int more = r;
        // 当前正在比较的下标
        int index = l;
        // 不能与 大于arr[r]的左边界 撞上
        while (index < more) {
            if (arr[index] < arr[r]) {
                // 小于时，将当前位置的数和小于arr[r]的右边界的下一个位置交换
                // 当前位置后移一位
                ArrayUtil.swap(arr, index++, ++less);
            } else if (arr[index] == arr[r]) {
                // 等于时，当前位置后移一位即可
                index++;
            } else {
                // 大于时，当前位置的数和大于arr[r]的左边界的前一个位置交换
                // 当前位置不动
                ArrayUtil.swap(arr, index, --more);
            }
        }
        // 将arr[r]位置的数和大于arr[r]的左边界的数交换
        // 此时整个数组就按照 小于、等于、大于arr[r] 分成了左中右三块
        ArrayUtil.swap(arr, more, r);

        // 最后整个数组中，等于arr[r]的左右边界分别是less + 1, more
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10, 20);
        int X = (int)(Math.random() * 20);
        ArrayUtil.traverseArray(arr);
        System.out.println(X);
        netherlandsFlag(arr, 0, arr.length - 1);
        ArrayUtil.traverseArray(arr);
    }
}
