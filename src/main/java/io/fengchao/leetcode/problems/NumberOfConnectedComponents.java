package io.fengchao.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponents {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        System.out.println(connected(5, edges));
    }

    private static int connected(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge : edges) {
            int nodeA = Math.min(edge[0], edge[1]);
            int nodeB = Math.max(edge[0], edge[1]);
            unionFind.union(nodeA, nodeB);
        }
        int num = unionFind.getNumConnected();
        return num;
    }

    static class UnionFind {
        int[] parent;
        int n;

        public UnionFind(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.n = n;
        }

        public void union(int nodeA, int nodeB) {
            // b join a
            int fatherB = findFather(nodeA);
            parent[nodeB] = fatherB;
        }

        public int findFather(int node) {
            int cur = node;
            while(parent[cur] != cur) {
                cur = parent[cur];
            }
            return cur;
            // Without path compression
        }

        public int getNumConnected() {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                set.add(findFather(i));
            }
            return set.size();
        }
    }
}
