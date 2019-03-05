package io.fengchao.leetcode.problems;

import java.util.*;

public class FindDuplicateAndSortElementsInArray {
  public static void main(String[] args) {
    int[] input = {5, 3, 6, 6, 6, 1, 2, 3, 2, 3, 2, 3, 2, 3, 8, 0, 8};
    FindDuplicateAndSortElementsInArray fd = new FindDuplicateAndSortElementsInArray();
    List<Integer> r = fd.solution(input);
    System.out.println(r);
  }

  private List<Integer> solution(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();
    for(int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    //这一句应该好好复习
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator
        .comparing(Map.Entry<Integer, Integer>::getValue).reversed().
        thenComparing(Map.Entry<Integer, Integer>::getKey));

    for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
      pq.offer(entry);
    }

    while(!pq.isEmpty()) {
      Map.Entry<Integer, Integer> entry = pq.poll();
      for(int i = 0; i < entry.getValue(); i++) {
        result.add(entry.getKey());
      }
    }

    return result;

  }
}
