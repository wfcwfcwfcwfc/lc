package io.fengchao;

import java.util.*;
import java.util.stream.Collectors;

public class FacebookDEPrep {
  public static void main(String[] args) {
    int n = 10;
    for(int i = 1; i < n; i+=2) {
      System.out.print(i + " ");
    }
    System.out.println();

    List<Integer> list = Arrays.asList(new Integer[]{1, 2,3,4,5});

    int[] intArray = new int[]{2,3,4,5,6,7};
    List<Integer> integerListFromIntArray = Arrays.stream(intArray).boxed().collect(Collectors.toList());
    int[] intArrayFromIntegerList = list.stream().mapToInt(i -> i).toArray();

    System.out.println();

    Collections.sort(integerListFromIntArray, Comparator.comparing(v -> v));
    Collections.sort(integerListFromIntArray, Comparator.reverseOrder());


    int sum = 0;
    for(int val : list) {
      sum += val;
    }
    System.out.println(sum);

    int number = 1234560;
    List<Integer> res = new ArrayList<>();
    while(number != 0) {
      int val = number % 10;
      res.add(val);
      number = number / 10;
    }

    Collections.reverse(res);
    System.out.println(res);


    // Center Average
    int[] input = new int[]{1,2,3,4,100};
    centerAverage(input);

    int[] input2 = new int[]{1,1,5,5,10,8,7};
    centerAverage(input2);

    int[] input3 = new int[]{-10,-4,-2,-4,-2,0};
    centerAverage(input3);

    Collections.reverse(integerListFromIntArray);
    Random random = new Random();
    random.nextInt(11);

    // Ceil and floor
    double a = 101.4563;
    double aCeil = Math.ceil(a);
    double aFloor = Math.floor(a);

    int b = 101;
    Math.ceil(b);
    System.out.println();


  }

  private static void centerAverage(int[] input) {
    if(input == null || input.length == 0) {
      return;
    }
    int min = input[0];
    int max = input[0];
    int sum = 0;
    for(int val : input) {
      min = Math.min(min, val);
      max = Math.max(max, val);
      sum += val;
    }

    sum = sum - min - max;
    int result = sum / (input.length - 2);
    System.out.println(result);
  }

  private static void hashMap(){
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "a");
    map.put(2, "b");
    map.put(45, "CCC");

    //iterate key
    Set<Integer> keySet = map.keySet();
    Collection<String> values = map.values();

  }

  private static void common() {

  }

}
