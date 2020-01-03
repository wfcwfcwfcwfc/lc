package io.fengchao.leetcode.problems;

public class BinarySearchJiuzhang {
    public static void main(String[] args) {
        int[] case1 = new int[]{1, 3, 4, 6, 7, 9};
        BinarySearchJiuzhang binarySearchJiuzhang = new BinarySearchJiuzhang();
        binarySearchJiuzhang.binarySearch(case1, 8);
    }

    private int binarySearch(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s + 1 < e) {
            int mid = s + (e - s) / 2;
            if(nums[mid] > target) {
                e = mid;
            } else if (nums[mid] < target) {
                s = mid;
            } else {
                s = mid;
            }
        }

        if(nums[s] > target) {
            return s;
        }
        if(nums[e] > target) {
            return e;
        }
        return nums.length;
    }
}
