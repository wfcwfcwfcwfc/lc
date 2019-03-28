package io.fengchao.corejava.applets.datastructure;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
  private void queueInterface() {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(123);
    queue.peek();
    queue.poll();


  }

  private void priorityQueue() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(1);
    pq.offer(3);
    pq.offer(5);
    pq.offer(4);
    System.out.println(pq.peek());
  }

  public static void main(String[] args) {
    MyQueue q = new MyQueue(5);
    q.offer(1);
    q.printAll();
    q.offer(2);
    q.printAll();
    q.offer(3);
    q.printAll();
    q.offer(4);
    q.printAll();
    q.offer(5);
    q.printAll();
    q.offer(6);
    q.printAll();

    q.poll();
    q.printAll();
    q.poll();
    q.printAll();
    q.offer(8);
    q.offer(9);
    q.printAll();

    QueueDemo qd = new QueueDemo();
    qd.priorityQueue();
  }


}

class MyQueue {
  private int size;
  private int[] array;
  private int start;
  private int end;

  public MyQueue(int size) {
    this.size = 0;
    this.array = new int[size];
    this.start = 0;
    this.end = 0;
  }

  public int offer(int val) {
    if(size == array.length) {
      return -1;
    }
    array[end] = val;
    end++;
    end = end % array.length;
    size++;
    return 1;
  }

  public int poll() {
    int result = array[start];
    start++;
    start = start % array.length;
    size--;
    return result;
  }

  public int peek() {
    return array[start];
  }

  public void printAll() {
    StringBuilder sb = new StringBuilder();
    for(int nbr : array) {
      sb.append(nbr);
      sb.append(" ");
    }
    System.out.println(sb.toString());
  }
}
