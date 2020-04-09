package io.fengchao.corejava;

import java.util.*;

public class TopKInMap {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.keySet();
    map.values();
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(Comparator.comparing((Map.Entry<String, Integer> entry) -> entry.getValue() ).reversed());
    Set<Map.Entry<String, Integer>> set = map.entrySet();
    for(Map.Entry<String, Integer> entry : set) {
      entry.getKey();
      entry.getValue();
    }

    String str = "Howareyou!";
    String pattern = "are";
    int pos = str.indexOf(pattern);

    String str1 = "Hi  llo";
    str1.split("\\s+");
    System.out.println(str1);

    System.out.println(Double.MIN_VALUE);
//    map.computeIfAbsent()

  }


}
