package io.fengchao.uiuc.cs412;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClusterValidation {
  public static void main(String[] args) {
    List<String> input = getDummyInput();
    double[][] probMatrix = calcCountMatrix(input);
    double nmi = calcNMI(probMatrix);

    System.out.println(nmi);
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

  private static double[][] calcCountMatrix(List<String> in) {

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

    double[][] probMtx = new double[cCount + 2][tCount + 2];
    for(int i = 0; i < cMtx.length; i++) {
      for(int j = 0; j < cMtx[0].length; j++) {
        probMtx[i][j] = (double)cMtx[i][j] / count;
      }
    }

    return probMtx;
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

  private static List<String> getInput() {
    Scanner scanner = new Scanner(System.in);
    List<String> result = new ArrayList<>();
    while(scanner.hasNext()) {
      result.add(scanner.nextLine());
    }
    return result;
  }

}
