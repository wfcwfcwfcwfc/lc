package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  public static void main(String[] args) {
    NQueens nQueens = new NQueens();
    List<List<String>> solution = nQueens.solveNQueens(4);

    for (List<String> strings : solution) {
      for (int j = 0; j < strings.size(); j++) {
        System.out.println(strings.get(j));
      }
      System.out.println();
      System.out.println();
    }

  }
  private List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    dfs(result, new ArrayList<>(), n);
    return result;
  }

  private void dfs(List<List<String>> result, List<Integer> path, int n) {
    if(path.size() == n) {
      result.add(printResult(path));
      return;
    }

    for(int i = 0; i < n; i++) {
      path.add(i);
      if(isValid(path)) {
        dfs(result, path, n);
      }
      path.remove(path.size() - 1);
    }
  }

  private boolean isValid(List<Integer> path) {
    int row = path.size() - 1;
    int col = path.get(path.size() - 1);
    for(int i = 0; i < path.size() - 1; i++) {
      if(path.get(i) == col) {
        return false;
      }
      if(i + path.get(i) == col + row) {
        return false;
      }
      if(i - path.get(i) == row - col) {
        return false;
      }
    }
    return true;
  }

  private List<String> printResult(List<Integer> input) {
    List<String> solution = new ArrayList<>();
    for(int i = 0; i < input.size(); i++) {
      StringBuilder sb = new StringBuilder();
      for(int j = 0; j < input.size(); j++) {
        if(j == input.get(i)) {
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      solution.add(sb.toString());
    }
    return solution;
  }
}
