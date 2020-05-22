package io.fengchao.uiuc.cs412;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class NaiveBayes {

  private static final int UNIQUE_CLASS_COUNT = 7;
  private static final double LAPLACHIAN_FACTOR = 0.1;
  public static void main(String[] args) {
//    List<String> raw = getInputFromFile();
    List<String> raw = getInput();
    List<List<int[]>> dataframes = buildDataFrame(raw);
    List<int[]> trainingSet = dataframes.get(0);
    List<int[]> testingSet = dataframes.get(1);
    classify(trainingSet, testingSet);
    System.out.println();
  }

  public static void classify(List<int[]> trainingSet, List<int[]> testingSet) {
//    int uniqueClassCount = (int)trainingSet.stream().map(row -> row[row.length - 1]).distinct().count();
    int totalRecordCount = trainingSet.size();
    int width = trainingSet.get(0).length;
    double[] classProb = new double[UNIQUE_CLASS_COUNT + 1];
    //calc class probability
    //Freq table
    Map<Integer, Integer> classFreqMap = trainingSet.stream().map(row -> row[row.length - 1]).
        collect(Collectors.toConcurrentMap(
            w -> w, w -> 1, Integer::sum));
    for(int i = 1; i <= 7; i++) {
      int classCount = classFreqMap.getOrDefault(i, 0);
      double prob = calcClassProbability(totalRecordCount, classCount, UNIQUE_CLASS_COUNT);
      classProb[i] = prob;
    }

    List<Integer> res = evalTestSet(trainingSet, testingSet, classFreqMap, classProb);
    printList(res);

  }

  private static List<Integer> evalTestSet(List<int[]> trainingSet, List<int[]> testingSet, Map<Integer, Integer> classFreqMap, double[] classProb) {
    List<Integer> res = new ArrayList<>();
    for(int[] testRow : testingSet) {
      //Calc prob on demand
      double[] condCountTbl = new double[UNIQUE_CLASS_COUNT + 1];
      Arrays.fill(condCountTbl, 1);
      for(int classId = 1; classId <= UNIQUE_CLASS_COUNT; classId++) {
        for(int attId = 0; attId < testRow.length - 1; attId++) {
          int finalClassId = classId;
          int finalAttId = attId;
          int attValue = testRow[attId];
          int conditionedSampleCount = (int)trainingSet.stream().filter(row -> row[row.length - 1] == finalClassId)
              .filter(row -> row[finalAttId] == attValue).count();
          int conditionClassCount = classFreqMap.getOrDefault(finalClassId, 0);
          int uniqueFeatureCount = (int)trainingSet.stream().map(row -> row[finalAttId]).distinct().count();
          double condProb = calcAttributeProbability(conditionedSampleCount, conditionClassCount, uniqueFeatureCount);
          condCountTbl[finalClassId] = condCountTbl[finalClassId] * condProb;
        }
      }

      int classResult = 0;
      double maxProb = 0;
      for(int i = 1; i <= UNIQUE_CLASS_COUNT; i++) {
        condCountTbl[i] = condCountTbl[i] * classProb[i];
        if(condCountTbl[i] >= maxProb) {
          classResult = i;
          maxProb = condCountTbl[i];
        }
      }
      res.add(classResult);
    }
    return res;
  }

  private static double calcClassProbability(int totalRecordCount, int classCount, int uniqueClassCount) {
    return (classCount + LAPLACHIAN_FACTOR) / (totalRecordCount + LAPLACHIAN_FACTOR * uniqueClassCount);
  }

  private static double calcAttributeProbability(int conditionedSampleCount, int conditionClassCount, int uniqueFeatureCount) {
    return (conditionedSampleCount + LAPLACHIAN_FACTOR) / (conditionClassCount + LAPLACHIAN_FACTOR * uniqueFeatureCount);
  }




  //Common IO functions
  /**
   * return list of int array for trainng and test data.
   * The dataframe looks like <code>List<int[]></code>
   * @param input
   * @return
   */
  private static List<List<int[]>> buildDataFrame(List<String> input) {
    List<List<int[]>> result = new ArrayList<>();
    int len = input.get(0).split(",").length;
    List<int[]> trainingData = new ArrayList<>();
    List<int[]> testData = new ArrayList<>();
    for(int i = 1; i < input.size(); i++) {
      String row = input.get(i);
      String[] rowSplit = row.split(",");
      int[] intRow = new int[rowSplit.length - 1];
      for (int j = 0; j < intRow.length; j++) {
        intRow[j] = Integer.parseInt(rowSplit[j + 1]);
      }
      if(intRow[intRow.length - 1] == -1) {
        testData.add(intRow);
      } else {
        trainingData.add(intRow);
      }
    }
    result.add(trainingData);
    result.add(testData);
    return result;
  }

  private static List<String> getInputFromFile() {
    try {
      List<String> res = Files.readAllLines(Paths.get("src/main/resources/naiveBayesData.txt"));
      return res;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static List<String> getInput() {
    Scanner scanner = new Scanner(System.in);
    List<String> result = new ArrayList<>();
    while(scanner.hasNext()) {
      result.add(scanner.nextLine());
    }
    return result;
  }

  public static void printList(List<Integer> res) {
    for(int val : res){
      System.out.println(val);
    }
  }
}
