package io.fengchao.leetcode.problems;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Coderpad {
  public static void main(String[] args) {

    //String functions
    String str = "abcdea";
    int pos = str.lastIndexOf('a');
    System.out.println("position1: " + pos);

    int pos1 = str.indexOf("abc");
    System.out.println("position2: " + pos1);

    int pos2 = str.indexOf("abc");
    System.out.println("position2: " + pos2);

    boolean pos3 = str.startsWith("abc");
    System.out.println("position2: " + pos3);

    //double approximates decimal numbers.
    double test1 = 1.0000000001;
    System.out.println(test1);

    Map<Character, Integer> map = new HashMap<>();
    map.put('a', 1);
    map.put('b', 3);
    map.put('c', 4);

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }

    for(Character c : map.keySet()) {
      System.out.println(c);
    }

    for (Integer integer : map.values()) {
      System.out.println(integer);
    }


  }
}
