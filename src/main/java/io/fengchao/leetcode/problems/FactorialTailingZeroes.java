package io.fengchao.leetcode.problems;

import java.math.BigInteger;

public class FactorialTailingZeroes {
  public static void main(String[] args) {
    int n = 30;
    BigInteger sum = BigInteger.valueOf(1);
    for(int i = 1; i <= 30; i++) {
      sum = sum.multiply(BigInteger.ONE);
    }
    System.out.println(sum);
  }
}
