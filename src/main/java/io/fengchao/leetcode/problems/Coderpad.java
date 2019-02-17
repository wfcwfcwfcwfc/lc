package io.fengchao.leetcode.problems;

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

  }
}
