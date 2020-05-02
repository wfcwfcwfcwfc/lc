package io.fengchao.uiuc.cs412;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClusterValidation {
  public static void main(String[] args) {
    List<String> input = getDummyInput();
    int[][] countMatrix = calcCountMatrix(input);
    double[][] probMatrix = convertProbMatrix(countMatrix, input.size());

    double nmi = calcNMI(probMatrix);
    double jaccard = calcJaccard(countMatrix);
    DecimalFormat decimalFormat = new DecimalFormat("0.000");
    System.out.print(decimalFormat.format(nmi));
    System.out.print(" ");
    System.out.println(decimalFormat.format(jaccard));
  }

  private static double calcNMI(double[][] probMtx) {
    double mi = 0;
    for(int i = 0; i < probMtx.length - 1; i++) {
      for(int j = 0; j < probMtx[0].length - 1; j++) {
        if(probMtx[i][j] == 0) {
          continue;
        }
        mi += probMtx[i][j] * Math.log(probMtx[i][j]
            / (probMtx[probMtx.length - 1][j] * probMtx[i][probMtx[0].length - 1]));
        System.out.print(mi + " ");
      }
      System.out.println("");
    }
    double hc = 0;
    for(int i = 0; i < probMtx.length - 1; i++) {
      double prob = probMtx[i][probMtx[0].length - 1];
      hc += prob * Math.log(prob);
    }

    double ht = 0;
    for(int i = 0; i < probMtx[0].length - 1; i++) {
      double prob = probMtx[probMtx.length - 1][i];
      ht += prob * Math.log(prob);
    }

    return mi / Math.sqrt(hc * ht);

  }

  private static int[][] calcCountMatrix(List<String> in) {

    //Get number of clusters in ground truth and clustering prediction
    int tCount = 0;
    int cCount = 0;
    int count = in.size();
    for(String str : in) {
      String[] strTC = str.split(" ");
      tCount = Math.max(tCount, Integer.parseInt(strTC[0]));
      cCount = Math.max(cCount, Integer.parseInt(strTC[1]));
    }

    int[][] cMtx = new int[cCount + 2][tCount + 2];
    //Build Cluster-Partition matrix
    for(String str : in) {
      String[] strTC = str.split(" ");
      cMtx[Integer.parseInt(strTC[1])][Integer.parseInt(strTC[0])]++;
      cMtx[Integer.parseInt(strTC[1])][tCount + 1]++;
      cMtx[cCount + 1][Integer.parseInt(strTC[0])]++;
    }
    return cMtx;
  }

  private static double[][] convertProbMatrix(int[][] countMatirx, int totalCount) {

    double[][] probMtx = new double[countMatirx.length][countMatirx[0].length];
    for(int i = 0; i < countMatirx.length; i++) {
      for(int j = 0; j < countMatirx[0].length; j++) {
        probMtx[i][j] = (double) countMatirx[i][j] / totalCount;
      }
    }
    return probMtx;
  }

  private static double calcJaccard(int[][] cMtx) {
    int tp = 0;
    for(int i = 0; i < cMtx.length - 1; i++) {
      for(int j = 0; j < cMtx[0].length - 1; j++) {
        if(cMtx[i][j] < 2) {
          continue;
        }
        tp += nC2(cMtx[i][j]);

      }
    }

    int fp = 0;
    for(int i = 0; i < cMtx[0].length - 1; i++) {
      fp += nC2(cMtx[cMtx.length - 1][i]);
    }
    fp -= tp;


    int fn = 0;
    for(int i = 0; i < cMtx.length - 1; i++) {
      fp += nC2(cMtx[i][cMtx[0].length - 1]);
    }
    fp -= tp;

    return tp / (double) (tp + fn + fp);

  }

  private static int nC2(int n) {
    return n * (n - 1) / 2;
  }

  private static int factorial(int n) {
    if(n == 0) {
      return 1;
    }
    int res = 1;
    for(int i = 1; i <= n; i++) {
      res *= i;
    }
    return res;
  }
  private static List<String> getDummyInput() {

    List<String> result = new ArrayList<>();
    result.add("2 3");
    result.add("0 0");
    result.add("0 1");
    result.add("1 1");
    result.add("2 2");
    return result;
  }

//  private static List<String> getInputFromFile() {
//    try {
//      List<String> res = Files.readAllLines(Paths.get("src/main/resources/cluster_validation.txt"));
//      return res;
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return null;
//  }

  private static List<String> getInput() {
    Scanner scanner = new Scanner(System.in);
    List<String> result = new ArrayList<>();
    while(scanner.hasNext()) {
      result.add(scanner.nextLine());
    }
    return result;
  }

}
