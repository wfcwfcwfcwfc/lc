package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
  public static void main(String[] args) {
    boolean result1 = isPrimeNumber1(23);
    System.out.println(result1);
    List<Integer> result2 = allPrimeNumber(100);
    result2.forEach(System.out::println);

  }

  private static boolean isPrimeNumber1(int n) {
    if(n == 0) {
      return false;
    }
    if(n == 1) {
      return true;
    }
    if(n == 2) {
      return true;
    }
    for(int i = 2; i < n; i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }

  private static List<Integer> allPrimeNumber(int n) {
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i <= n; i++) {
      if(isPrimeNumber1(i)) {
        result.add(i);
      }
    }
    return result;
  }
}
