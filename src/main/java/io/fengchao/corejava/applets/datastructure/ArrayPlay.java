package io.fengchao.corejava.applets.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ArrayPlay {
  public static void main(String[] args) {
    List<Bar> list = new ArrayList();
    Bar b1 = new Bar(2);
    Bar b2 = b1;
    list.add(b1);
    list.add(b2);
    System.out.println(list.size());
  }
}

class Bar {
  int a;

  public Bar(int i) {
    this.a = i;
  }
}