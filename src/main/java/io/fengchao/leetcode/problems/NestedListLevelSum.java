package io.fengchao.leetcode.problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedListLevelSum {
  public static void main(String[] args) {
    List<NestedInteger> input = new ArrayList<>();
    NestedListLevelSum nestedListLevelSum = new NestedListLevelSum();
    NestedInteger ni1 = new NestedInteger(1, null);
    NestedInteger ni2 = new NestedInteger(1, Arrays.asList(new NestedInteger(3, null), new NestedInteger(5, null)));
    NestedInteger ni3 = new NestedInteger(4, null);
    NestedInteger ni4 = new NestedInteger(6, null);
    NestedInteger ni5 = new NestedInteger(9, null);
    NestedInteger ni6 = new NestedInteger(2, Arrays.asList(new NestedInteger(1, null)));

  }


}

class NestedInteger {
  private boolean isInteger;
  private int val;
  List<NestedInteger> list;

  public NestedInteger(int val, List<NestedInteger> list) {
    this.val = val;
    this.list = list;
  }

  public boolean isInteger(){
    return isInteger;
  }

  public boolean isList() {
    return !isInteger;
  }

  public int getInteger() {
    return val;
  }

  public List<NestedInteger> getList() {
    return list;
  }

}
