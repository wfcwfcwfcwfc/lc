package io.fengchao.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPractice {
  public static void main(String[] args) {
    int[][] array = new int[0][1];

    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    int[] convertedArray = list.stream().mapToInt(i -> i).toArray();
    List<Integer> aList = Arrays.stream(convertedArray).boxed().collect(Collectors.toList());

  }
}
