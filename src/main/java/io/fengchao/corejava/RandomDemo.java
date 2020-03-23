package io.fengchao.corejava;

import java.util.Random;

public class RandomDemo {
  public static void main(String[] args) {
    Random random = new Random(10);
    int randomValue = random.nextInt(5) + 5;
  }
}
