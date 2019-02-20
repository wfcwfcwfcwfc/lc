package io.fengchao.leetcode.problems;


/**
 * LC 405
 */
public class DecToHex {
  public static void main(String[] args) {
//    System.out.println(Integer.toHexString(123));
//    System.out.println(toBinary(-8));
//    System.out.println(1 << 4);
    System.out.println(Integer.toBinaryString(-1));

    //One's complement and two's complement
    System.out.println("======== BEGIN ========");
    int nbr = 6;
    System.out.print("Initial bits for " + nbr + ": " );
    System.out.println(Integer.toBinaryString(nbr));
    nbr = makeNegative(nbr);
    System.out.println("After operation bits: " + nbr);
    System.out.println(Integer.toBinaryString(nbr));
    System.out.println("========");

    System.out.println("======== BEGIN ========");
    //Convert decimal to binary
    System.out.println("Decimal to binary");
    System.out.println(toBinary(256));
    System.out.println("========");

    //Binary to Decimal
    System.out.println("======== BEGIN ========");
    System.out.println("Binary to Decimal");
    System.out.println(binToInteger("10000"));
    System.out.println("========");

  }

  private static String toBinary(int number) {
    StringBuilder sb = new StringBuilder();
    while(number != 0) {
      sb.append(number & 1);
      number = (number >> 1);
    }
    return sb.reverse().toString();
  }

  private static int binToInteger(String bin) {
    int result = 0;
    for(char c : bin.toCharArray()) {
      if(c == '1') {
        result = result * 2 + 1;
      } else if (c == '0') {
        result = result * 2;
      } else {
        throw new RuntimeException();
      }
    }
    return result;
  }

  private static int makeNegative(int nbr) {
    return ~nbr + 1;
  }

}
