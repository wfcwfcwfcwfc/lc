package io.fengchao.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class NbrConnCompUndirGraph {
  public int countComponents(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);
    for(int[] edge : edges) {
      uf.union(edge[0], edge[1]);
    }
    return uf.reportUnique();

  }

  class UnionFind {
    int[] union;
    public UnionFind(int n) {
      union = new int[n];
      for(int i = 0; i < n; i++) {
        union[i] = i;
      }
    }

    public int findFather(int i) {
      int elem = i;
      while(union[elem] != elem) {
        elem = union[elem];
      }
      return elem;
    }

    public void union(int a, int b) {
      int pa = findFather(a);
      int pb = findFather(b);
      union[pb] = pa;
    }

    public int reportUnique() {
      Set<Integer> set = new HashSet<>();
      for(int i = 0; i < union.length; i++) {
        union[i] = findFather(i);
      }
      for(int nbr : union) {
        set.add(nbr);
      }
      return set.size();
    }
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] edges = {{0, 1}, {2, 3},{1, 2}};
    NbrConnCompUndirGraph graph = new NbrConnCompUndirGraph();
    int components  = graph.countComponents(n, edges);
    System.out.println(components);
  }
}