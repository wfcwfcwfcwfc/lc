package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Basically testing regular expression skills.
 */
public class DistinctWords {
  public static void main(String[] args) {
    String input = "How are you, today,     tony?";
    String[] word = input.split("\\s+|[.,?]");
    List<Integer> list = new ArrayList<Integer>();
    Collections.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return 0;
      }
    });
  }
}
