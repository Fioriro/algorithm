package com.algorithm.array.sorted_squares;

public class SortedSquares {
    public static void main(String[] args) {

        int[] testArr = {-4, -1, 0, 3, 6};
        System.out.println("the origin array: ");
        traverse(testArr);
        System.out.println("after squaring: " );
        traverse(sortedSquares(testArr));
    }

    public static int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1,k = nums.length - 1;
        while (i <= j) {
            if(nums[i] * nums[i] < nums[j] * nums[j]){
                res[k--] = nums[j] * nums[j];
                j--;
            }else {
                res[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }

    public static void traverse(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
