package com.algorithm.array.remove_element;

public class RemoveElement {

    public static void main(String[] args) {

        int[] testArr = {-1,2,3,2,4,5};
        int val = 2;
        System.out.println("the origin length of testArray: " + testArr.length);
        System.out.println("after removing element: " + removeElement(testArr,val));
    }

    public static int removeElement(int[] nums, int val) {

        int fast = 0, slow = 0;
        while (fast < nums.length){
            if(nums[fast] != val){ //不满足，快慢一起移动
                nums[slow++]  = nums[fast];
            }
            fast++; // 满足就只有快指针移动
        }
        return slow;
    }
}
