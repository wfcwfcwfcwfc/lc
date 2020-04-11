package io.fengchao.leetcode.problems.templates;

import java.util.ArrayList;
import java.util.List;

public class partitionArray {
  public static void main(String[] args) {
    int[] in = new int[]{1,2,3,4,5,6,7,8};
    List<List<String>> result = new ArrayList<>();
    helper(in, new ArrayList<>(), result, 0, 3, 1);
    System.out.println(result);
  }

//  public static List<List<Integer>> partition(int[] input, int m) {
//    helper(input, )
//  }

  private static void helper2(int arrayLength, int partitionNum, List<List<Integer>> result, List<Integer> temp) {
    
  }


  /**
   * 这么写起来其实不太方便 弄到最后是List<List<List<Integer>>>套好几层
   * 不如记录分区坐标更高效
   * @param input
   * @param part
   * @param result
   * @param i
   * @param m
   * @param par
   */
  private static void helper(int[] input, List<String> part, List<List<String>> result, int i, int m, int par) {
    if(i == input.length && part.size() == m) {
      result.add(new ArrayList<>(part));
      return;
    }
    if(i == input.length) {
      return;
    }
    if(par == m) {
      return;
    }

    //same subarray
    part.add(""+input[i]);
    helper(input, part, result, i + 1, m, par);
    part.remove(part.size() - 1);

    //new subarray
    if(i > 0) {
      part.add(",");
      part.add("" + input[i]);
      helper(input, part, result, i + 1, m, par + 1);
      part.remove(part.size() - 1);
      part.remove(part.size() - 1);
    }

  }


}
