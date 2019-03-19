package io.fengchao.java.applets.multithreading;

public class JoinDemo {
  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      for(int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
      }
    });

    Thread thread2 = new Thread() {
      @Override
      public void run() {
        try {
          thread1.join();
        } catch (InterruptedException e) {

        }

        for(int i = 0; i < 100; i++) {
          System.out.println(Thread.currentThread().getName() + " " + i);
        }
      }
    };

    thread1.start();
    thread2.start();
  }
}
