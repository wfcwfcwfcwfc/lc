package io.fengchao.leetcode.problems;


import java.util.Comparator;
import java.util.PriorityQueue;

class KCloestPoints {
  public static void main(String[] args) {
//    int[][] input = new int[][]{{1,1},{3,3},{2,2},{6,6},{10, 10}, {8,8}};
    int[][] input = new int[][]{{1,3}, {-2,2}};
    int[][] result = kClosest(input, 3);
    System.out.println();

  }
  public static int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] point) -> point[0] * point[0] + point[1] * point[1]).reversed());

    for(int[] point : points) {
      pq.offer(point);
      if(pq.size() >= K) {
        pq.poll();
      }
    }
    int[][] result = new int[K][2];
    pq.toArray(result);
    return result;

  }
}