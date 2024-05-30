package com.algorithm.array.binary_search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] testArr = {-1,2,4,5,6,8,9};
        int target = 3;
        System.out.println(search(testArr,target));
    }


    //if the given number exists in the array, return the corresponding index
    //otherwise, return -1
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
