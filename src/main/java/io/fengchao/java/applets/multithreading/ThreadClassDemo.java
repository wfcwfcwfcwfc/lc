package io.fengchao.java.applets.multithreading;

public class ThreadClassDemo {
  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread() {
      @Override
      public void run() {
        for(int i = 0; i <= 10; i++) {
          System.out.println("第1个线程执行" + i * 10 + "%");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };

    Thread thread2 = new Thread(() -> {
      for(int i = 0; i <= 10; i++) {
        System.out.println("第2个线程执行" + i * 10 + "%");
      }
    });

    Thread thread3 = new Thread(new PrintStuff(), "newThread3");

    thread1.start();
    thread2.start();
    thread3.start();
    System.out.println(thread3.getName());
    Thread currentThread = Thread.currentThread();
    System.out.println(currentThread.getName());
  }
}
