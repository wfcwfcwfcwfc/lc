package io.fengchao.leetcode.problems;


class QuickSelect {
  public int findKthLargest(int[] nums, int k) {
    return helper(nums, 0, nums.length - 1, k);
  }

  private int helper(int[] nums, int start, int end, int k) {
    if(start == end) {
      return nums[start];
    }
    int i = start, j = end;
    int pivot = nums[(start + end) / 2];
    while(i <= j) {

      while(i <= j && nums[i] > pivot) {
        i++;
      }

      while(i <= j && nums[j] < pivot) {
        j--;
      }

      if(i <= j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
      }

    }

    if(start + k - 1 <= j) {
      return helper(nums, start, j, k);
    }

    if(start + k - 1 >= i) {
      return helper(nums, i, end, k - (i - start));
    }

    return nums[j + 1];

  }
}