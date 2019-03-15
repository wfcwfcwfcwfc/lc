package io.fengchao.java.applets.multithreading;

public class PrintStuff implements Runnable {
  @Override
  public void run() {
    for(int i = 0; i <= 10; i++) {
      System.out.println(i);
    }
  }
}
