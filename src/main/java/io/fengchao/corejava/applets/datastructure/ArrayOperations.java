package io.fengchao.corejava.applets.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayOperations {
  public static void main(String[] args) {
    List<Bar> list = new ArrayList();
    Bar b1 = new Bar(2);
    Bar b2 = b1;
    list.add(b1);
    list.add(b2);
    System.out.println(list.size());
  }

  private void ArrayAndList() {
    int[] intArray = {1, 2, 3};

    //Integer[] works with Arrays.asList
    Integer[] intArray2 = new Integer[]{1, 2, 3};
    List<Integer> list = Arrays.asList(intArray2);

    List<Integer> list2 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
//    List<Integer> list3 = new ArrayList<>(Arrays.asList(intArray));

//    ArrayList<Integer> list4 = Arrays.stream(intArray).collect(Collectors.toCollection(ArrayList::new));

//    int[] array1 = list2.toArray(new int[0]);




  }
}

class Bar {
  int a;

  public Bar(int i) {
    this.a = i;
  }
}