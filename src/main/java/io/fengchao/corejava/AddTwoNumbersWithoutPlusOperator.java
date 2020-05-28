package io.fengchao.corejava;

public class AddTwoNumbersWithoutPlusOperator {

  public static void main(String[] args) {

    //迭代的思维不好想

    int a = 3;
    int b = 5;
    int aPrime, bPrime = 0;

    while(b != 0) {
      aPrime = a ^ b;
      bPrime = (a & b) << 1;
      a = aPrime;
      b = bPrime;
    }

    System.out.println(a);
  }
}
