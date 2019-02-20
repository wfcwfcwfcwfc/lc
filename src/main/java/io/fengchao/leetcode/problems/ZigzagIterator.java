package io.fengchao.leetcode.problems;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {

  List<List<Integer>> lists;
  List<Integer> offsets;
  int p = 0;
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    lists = new ArrayList<List<Integer>>();
    offsets = new LinkedList<Integer>();
    if(v1 != null && v1.size() > 0) {
      lists.add(v1);
      offsets.add(0);
    }
    if(v2 != null && v2.size() > 0) {
      lists.add(v2);
      offsets.add(1);
    }
  }

  public int next() {
    int val = lists.get(p).get(offsets.get(p));
    offsets.set(p, offsets.get(p) + 1);
    if(offsets.get(p) >= lists.get(p).size()) {
      offsets.remove(p);
      lists.remove(p);
    }
    p++;
    return val;
  }

  public boolean hasNext() {
    if(lists.size() == 0) {
      return false;
    }
    p = p % lists.size();
    if(lists.get(p) != null && lists.get(p).size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2);
    List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

    ZigzagIterator zigzagIterator = new ZigzagIterator(list1, list2);

    while(zigzagIterator.hasNext()) {
      System.out.print(zigzagIterator.next() + " ");
    }
  }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
