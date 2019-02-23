package io.fengchao.applets;

public class ThreadSafeSingleton {
  private static ThreadSafeSingleton INSTANCE;

  public static ThreadSafeSingleton init(){
    if(INSTANCE == null){
      synchronized (ThreadSafeSingleton.class) {
        if(INSTANCE == null) {
          INSTANCE = new ThreadSafeSingleton();
        }
      }
    }
    return INSTANCE;
  }
}
