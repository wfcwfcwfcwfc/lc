package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
  public static void main(String[] args) {
    Permutation permutation = new Permutation();
    int n = 5;
    List<List<Integer>> result = new ArrayList<>();
    permutation.dfs(result, new ArrayList<Integer>(), n, new boolean[n + 1]);
    permutation.printListList(result);

  }

  private void dfs(List<List<Integer>> result, List<Integer> temp, int n, boolean[] visited) {
    if(temp.size() == n) {
      result.add(new ArrayList<>(temp));
      return;
    }
    for(int i = 1; i <= n; i++) {
      if(visited[i]) {
        continue;
      }
      temp.add(i);
      visited[i] = true;
      dfs(result, temp, n, visited);
      temp.remove(temp.size() - 1);
      visited[i] = false;
    }
  }

  private void printListList(List<List<Integer>> input) {
    input.stream().forEach(list -> {
      list.forEach(System.out::print);
      System.out.println();
    });
  }
}
