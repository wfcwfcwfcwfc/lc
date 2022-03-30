package io.fengchao.corejava;

public class BasicBitManipulation {
  public static void main(String[] args) {

    //基本位运算
    int a = 10; //00001010
    int b = 38; //00100110

    //000000010 = 2
    System.out.println(a & b);

    //000101110 = 32 +8 +4 +2 = 46
    System.out.println(a | b);

    //000101100 = 32 + 8 + 4 = 44
    System.out.println(a ^ b);

    // ~a = 11110101 =
    System.out.println(~a);

    // 20
    System.out.println(a << 1);

    //5
    System.out.println(a >> 1);

    System.out.println(a >>> 1);

    System.out.println(-10 >> 1);

    // 0/1 based counting 计数

    //把n的i到j位覆盖成m
    int i = 2, j = 6;
    int n = 1024, m = 21;
    int init = -1;
    int step1 = init << (31 - j);
    int step2 = step1 >>> (31 - j + i);
    int step3 = step2 << i;
    int step4 = ~step3;
    int step5 = n & step4;
    int res = step5 | (m << i);
    System.out.println(res);

    int highBit = a & (a - 1);
    int lowBit = a & -a;
    System.out.println();

  }
}
