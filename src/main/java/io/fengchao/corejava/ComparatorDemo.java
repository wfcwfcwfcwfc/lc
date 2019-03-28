package io.fengchao.corejava;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
  public static void main(String[] args) {
    Integer[] input = new Integer[]{1, 5, 8, 3, 4, 2, 6, 99};
    print(input);
    Arrays.sort(input);
    print(input);

    Comparator reverseOrder = Comparator.reverseOrder();
    Arrays.sort(input, reverseOrder);
    print(input);
  }

  public static void print(Integer[] input) {
    for(int num : input) {
      System.out.print(num);
    }
    System.out.println();
  }
}


