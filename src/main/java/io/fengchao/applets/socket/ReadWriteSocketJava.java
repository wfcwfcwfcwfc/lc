package io.fengchao.applets.socket;

import java.util.LinkedList;
import java.util.List;

public class ReadWriteSocketJava {

  public static void main(String[] args) {
    Object o = new LinkedList();
    System.out.println(o instanceof List);
    System.out.println(o.getClass().getSimpleName());
  }
}
