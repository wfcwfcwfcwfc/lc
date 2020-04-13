package io.fengchao.uiuc.cs412;

import java.io.*;
import java.util.*;

public class Hierarchical {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    List<String> input = getDummyInput();
    String[] meta = input.get(0).split(" ");
    int N = Integer.parseInt(meta[0]);
    int K = Integer.parseInt(meta[1]);
    int M = Integer.parseInt(meta[2]);
    // printHelper(input);
    input.remove(0);
    double[][] inArray = new double[N][2];
    for(int i = 0; i < N; i++) {
      inArray[i][0] = Double.parseDouble(input.get(i).split(" ")[0]);
      inArray[i][1] = Double.parseDouble(input.get(i).split(" ")[1]);
    }

    List<List<double[]>> result = calc(inArray, K, M);
    Map<double[], Integer> lookup = new HashMap<>();
    for(int i = 0; i < result.size(); i++) {
      for(double[] point : result.get(i)) {
        lookup.put(point, i);
      }
    }
    List<Integer> finalResult = new ArrayList<>();
    for(double[] p : inArray) {
      finalResult.add(lookup.get(p));
    }
    System.out.println(finalResult);

  }

  private static List<List<double[]>> calc(double[][] in, int K, int M) {
    List<List<double[]>> clusters = new ArrayList<>();
    for(double[] point : in) {
      List<double[]> cluster = new ArrayList<>();
      cluster.add(point);
      clusters.add(cluster);
    }

    while(clusters.size() > K) {
      List<double[]> cluster1 = null;
      List<double[]> cluster2 = null;
      double minDist = Double.MAX_VALUE;

      for(int i = 0; i < clusters.size(); i++) {
        for(int j = i + 1; j < clusters.size(); j++) {
          List<double[]> c1 = clusters.get(i);
          List<double[]> c2 = clusters.get(j);
          double dist = calcDist(c1, c2, M);
          if(dist < minDist) {
            cluster1 = c1;
            cluster2 = c2;
            minDist = Math.min(dist, minDist);
          }
        }
      }

      //merge
      cluster1.addAll(cluster2);
      clusters.remove(cluster2);
    }

    return clusters;

  }

  private static double calcDist(List<double[]> c1, List<double[]> c2, int M) {
    //
    if(M == 0) {
      double min = Double.MAX_VALUE;
      for(double[] p1 : c1) {
        for(double[] p2 : c2) {
          double dist = eucDist(p1, p2);
          min = Math.min(min, dist);
        }
      }
      return min;
    }

    if(M == 1) {
      double max = 0;
      for(double[] p1 : c1) {
        for(double[] p2 : c2) {
          max = Math.max(max, eucDist(p1, p2));
        }
      }
      return max;

    }

    if(M == 2) {
      double sum = 0;
      for(double[] p1 : c1) {
        for(double[] p2 : c2) {
          sum  += eucDist(p1, p2);
        }
      }

      return sum / (c1.size() * c2.size());
    }
    return 0;
  }

  private static double eucDist(double[] p1, double[] p2) {
    return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
  }

  private static List<String> getDummyInput() {

    List<String> result = new ArrayList<>();
    result.add("5 2 0");
    result.add("51.5217 30.1140");
    result.add("27.9698 27.0568");
    result.add("10.6233 52.4207");
    result.add("122.1483 6.9586");
    result.add("146.4236 -41.3457");

    return result;
  }

  private static List<String> getInput() {
    Scanner scanner = new Scanner(System.in);
    List<String> result = new ArrayList<>();
    while(scanner.hasNext()) {
      result.add(scanner.nextLine());
    }
    return result;
  }

  private static void printHelper(List<String> in) {
    for(String str : in) {
      System.out.println(str);
    }
  }


}
