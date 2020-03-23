package io.fengchao.leetcode.problems;

public class QuickSort {
  public static void main(String[] args) {
    int[] input = {2, 5, 8, 3};
    quickSort(input, 0, input.length - 1);
    System.out.println(input);
  }

  public static void quickSort(int[] nums, int start, int end) {
    if(start >= end) {
      return;
    }
    int pivot = partition(nums, start, end);
    quickSort(nums, start, pivot - 1);
    quickSort(nums, pivot + 1, end);

  }

  private static int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int pos = start;
    for(int i = start; i < end; i++) {
      if(nums[i] < pivot) {
        int temp = nums[pos];
        nums[pos] = nums[i];
        nums[i] = temp;
        pos++;
      }
    }
    int temp = nums[pos];
    nums[pos] = pivot;
    nums[end] = temp;
    return pos;
  }
}
