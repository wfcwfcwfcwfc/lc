package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * From (0, 0) to (m - 1, n - 1), top left to bottom right.
 */
public class MatrixPaths {
  public static void main(String[] args) {
    int[][] matrix1 = {
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
    };

    matrixPath(matrix1);
  }

  public static void matrixPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    int[][] visited = new int[matrix.length][matrix[0].length];
    List<Integer[]> p = new ArrayList<>();
    boolean result = helper(matrix, visited, 0, 0, p);
    System.out.println(result);
    p.stream().forEach(array -> {
      System.out.println(array[0] + "," + array[1]);
    });
  }


  //Return if there exists one valid path
  public static boolean helper(int[][] matrix, int[][] visited, int x, int y, List<Integer[]> path) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
        || matrix[x][y] == 0 || visited[x][y] == 1) {
      return false;
    }
    visited[x][y] = 1;
    path.add(new Integer[]{x, y});
    if (x == matrix.length - 1 && y == matrix[0].length - 1) {
      return true;
    }
    if (helper(matrix, visited, x - 1, y, path) || helper(matrix, visited, x + 1, y, path)
        || helper(matrix, visited, x, y + 1, path) || helper(matrix, visited, x, y - 1, path)) {
      return true;
    }
    //到底要不要设置为0
    visited[x][y] = 0;
    path.remove(path.size() - 1);
    return false;
  }
}
