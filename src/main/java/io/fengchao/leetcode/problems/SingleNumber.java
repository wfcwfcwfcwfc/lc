package io.fengchao.leetcode.problems;

public class SingleNumber {
  public static void main(String[] args) {
    SingleNumber singleNumber = new SingleNumber();
    int[] input = new int[]{1, 2, 2, 1, 4, 9, 4, 7};
    singleNumber.singleNumber(input);
  }

  private int singleNumber(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      System.out.println("Sum's value: " + Integer.toBinaryString(sum));
      System.out.println("Num's value: " + Integer.toBinaryString(nums[i]));
      if(i == 0) {
        sum = nums[i];
      } else {
        sum ^= nums[i];
      }
      System.out.println("After XOR: " + Integer.toBinaryString(sum));
    }
    return sum;
  }

  private int singleNumberII(int[] nums) {
    return 0;
  }
}
