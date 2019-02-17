package io.fengchao.leetcode.problems;

class FindKthLargest {
  private int findKthLargest(int[] nums, int k) {
    if(nums == null || nums.length == 0 || k > nums.length) {
      return -1;
    }
    return helper(nums, k, 0, nums.length - 1);
  }

  private int helper(int[] nums, int k, int start, int end) {
    if(start == end) {
      return nums[start];
    }
    int p = partition(nums, start, end);
    if(p == k - 1) {
      return nums[p];
    } else if (p < k - 1) {
      return helper(nums, k, p + 1, end);
    } else {
      return helper(nums, k, start, p - 1);
    }

  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private int partition(int[] nums, int start, int end) {
    int pivotVal = nums[end];
    int p = start;
    for(int i = start; i < end; i++) {
      if(nums[i] >= pivotVal) {
        swap(p, i, nums);
        p++;
      }
    }
    swap(p, end, nums);
    return p;
  }

  public static void main(String[] args) {
    FindKthLargest findKthLargest = new FindKthLargest();
    int val = findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    System.out.println(val);
  }
}