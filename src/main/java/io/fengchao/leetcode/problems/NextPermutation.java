package io.fengchao.leetcode.problems;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] input1 = {1, 2, 3};
        int[] input2 = {1, 3, 2};
        nextPermutation.nextPermutation(input2);
    }
    public void nextPermutation(int[] nums) {
        //find first decreasing element
        int firstDescDigit = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstDescDigit = i;
                break;
            }
        }
        if (firstDescDigit == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        //find next greater element
        int firstGreaterElem = firstDescDigit + 1;
        for (int i = nums.length - 1; i > firstDescDigit; i--) {
            if (nums[i] > nums[firstDescDigit]) {
                firstGreaterElem = i;
                break;
            }
        }

        int temp = nums[firstGreaterElem];
        nums[firstGreaterElem] = nums[firstDescDigit];
        nums[firstDescDigit] = temp;

        reverse(nums, firstDescDigit + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

}

