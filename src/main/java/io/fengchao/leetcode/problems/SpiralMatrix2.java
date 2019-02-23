package io.fengchao.leetcode.problems;

public class SpiralMatrix2 {
  public static int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int start = 0;
    int end = n - 1;
    int counter = 1;
    while(start <= end) {
      for(int i = start; i <= end; i++) {
        result[start][i] = counter++;
      }
      for(int i = start + 1; i <= end; i++) {
        result[i][end] = counter++;
      }
      for(int i = end - 1; i >= start; i--) {
        result[end][i] = counter++;
      }
      for(int i = end - 1; i >= start; i--) {
        result[i][start] = counter++;
      }
      start++;
      end--;
    }
    return result;
  }

  public static void main(String[] args) {
    generateMatrix(3);
  }
}
