package io.fengchao.corejava.applets.multithreading;

// Java code for thread creation by implementing
// the Runnable Interface
class MultithreadingDemoR implements Runnable
{
  public void run()
  {
    try
    {
      // Displaying the thread that is running
      System.out.println ("Thread " +
          Thread.currentThread().getId() +
          " is running");

    }
    catch (Exception e)
    {
      // Throwing an exception
      System.out.println ("Exception is caught");
    }
  }
}

// Main Class
class JavaRunnable
{
  public static void main(String[] args)
  {
    int n = 8; // Number of threads
    for (int i=0; i<8; i++)
    {
      Thread object = new Thread(new MultithreadingDemoR());
      object.start();
    }
  }
}
