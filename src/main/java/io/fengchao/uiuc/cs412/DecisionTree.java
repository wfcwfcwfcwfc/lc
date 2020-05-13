package io.fengchao.uiuc.cs412;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DecisionTree {

  private static final int MAX_DEPTH = 5;
  private static final int MIN_RECORDS = 3;

  public static void main(String[] args) {
//    List<String> input = getInputFromFile();
    List<String> input = getInput();
    List<List<int[]>> data = buildDataFrame(input);
    List<int[]> trainingSet = data.get(0);
    List<int[]> testSet = data.get(1);
    TreeNode tree = buildDecisionTree(trainingSet, new HashSet<>(), 0);
    List<Integer> result = evaluateTestSet(tree, testSet);
    printList(result);

  }

  public static TreeNode buildDecisionTree(List<int[]> df, Set<Integer> usedAtt, int depth) {
    //Ending condition
    if(depth == MAX_DEPTH || df.size() < MIN_RECORDS) {
      List<Integer> klassList = df.stream().map(row -> row[row.length - 1]).collect(Collectors.toList());
      Map<Integer, Integer> counts = klassList.parallelStream().
          collect(Collectors.toConcurrentMap(
              w -> w, w -> 1, Integer::sum));

      //find majority
      int maxVal = 0;
      int maxClass = -1;
      for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        if(entry.getValue() > maxVal) {
          maxVal = entry.getValue();
          maxClass = entry.getKey();
        }
      }

      TreeNode node = new TreeNode();
      node.klass = maxClass;
      return node;
    }

    //Select a attribute by finding the minimal gini index
    int attId = 0;
    double gini = 1;
    for(int i = 0; i < df.get(0).length - 1; i++) {
      if(usedAtt.contains(i)) {
        continue;
      }
      double candidateGini = calcCondGiniIndex(df, i);
      if(candidateGini < gini) {
        gini = candidateGini;
        attId = i;
      }
    }

    TreeNode node = new TreeNode();
    node.attribute = attId;
    usedAtt.add(attId);
    int finalAttId = attId;
    List<Integer> attVals = df.stream().map(row -> row[finalAttId]).distinct().collect(Collectors.toList());
    for(int attVal : attVals) {
      List<int[]> subset = df.stream().filter(row -> row[finalAttId] == attVal).collect(Collectors.toList());
      TreeNode child = buildDecisionTree(subset, new HashSet<>(usedAtt), depth + 1);
      node.children.put(attVal, child);
    }

    return node;

  }

  public static double calcGiniIndex(List<int[]> dataframe) {
    //Just calculate, no conditioning
    Map<Integer, Integer> freq = new HashMap<>();
    for(int[] row : dataframe) {
      int klass = row[row.length - 1];
      freq.putIfAbsent(klass, 0);
      freq.put(klass, freq.get(klass) + 1);
    }
    double sum = 0;
    int size = dataframe.size();
    for(int val : freq.values()) {
      sum += ((double)val / size) * ((double)val / size);
    }

    return 1 - sum;
  }

  /**
   * Calculate conditional gini index
   * @param dataframe
   * @param attributeId
   * @return
   */
  public static double calcCondGiniIndex(List<int[]> dataframe, int attributeId) {
    //partition, calc partition probability, then multiply sum with each gini index
    Map<Integer, Integer> freqMap = new HashMap<>();
    for(int[] row : dataframe) {
      int attValue = row[row.length - 1];
      freqMap.putIfAbsent(attValue, 0);
      freqMap.put(attValue, freqMap.get(attValue) + 1);
    }
    double res = 0;
    int size = dataframe.size();
    for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      int key = entry.getKey();
      int frequency = entry.getValue();
      double prob = (double)frequency / size;
      List<int[]> subDataframe = dataframe.stream().filter(row -> row[attributeId] == key).collect(Collectors.toList());
      double gini = calcGiniIndex(subDataframe);
      res += prob * gini;
    }
    return res;
  }

  public static List<Integer> evaluateTestSet(TreeNode root, List<int[]> testDf) {
    List<Integer> result = new ArrayList<>();
    for(int[] row : testDf) {
      int klass = evalTestRow(root, row);
      result.add(klass);
    }
    return result;
  }

  public static int evalTestRow(TreeNode root, int[] row) {
    if(root.klass != -1) {
      return root.klass;
    }
    int attribute = root.attribute;
    int attrVal = row[attribute];
    if(root.children.get(attrVal) != null) {
      return evalTestRow(root.children.get(attrVal), row);
    } else {
//      System.out.println("Could Not find branch");
      return 0;
    }
  }


  /**
   * return list of int array for trainng and test data.
   * The dataframe looks like <code>List<int[]></code>
   * @param input
   * @return
   */
  private static List<List<int[]>> buildDataFrame(List<String> input) {
    List<List<int[]>> result = new ArrayList<>();
    int len = Integer.parseInt(input.get(0));
    int i = 1;
    List<int[]> trainingData = new ArrayList<>();
    for (; i <= len; i++) {
      String row = input.get(i);
      String[] rowSplit = row.split(" ");
      int[] rowRes = new int[rowSplit.length];
      for (int j = 0; j < rowSplit.length; j++) {
        if (j == 0) {
          rowRes[rowRes.length - 1] = Integer.parseInt(rowSplit[j]);
        } else {
          rowRes[j - 1] = Integer.parseInt(rowSplit[j].split(":")[1]);
        }
      }
      trainingData.add(rowRes);
    }
    result.add(trainingData);

    List<int[]> testData = new ArrayList<>();
    len = Integer.parseInt(input.get(i)) + i;
    i++;
    for (; i <= len; i++) {
      String row = input.get(i);
      String[] rowSplit = row.split(" ");
      int[] rowRes = new int[rowSplit.length];
      for (int j = 0; j < rowSplit.length; j++) {
        rowRes[j] = Integer.parseInt(rowSplit[j].split(":")[1]);
      }
      testData.add(rowRes);
    }
    result.add(testData);
    return result;
  }


  private static List<String> getInputFromFile() {
    try {
      List<String> res = Files.readAllLines(Paths.get("src/main/resources/decisioinTreeTestData.txt"));
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

  static class TreeNode {
    int attribute;
    int klass;
    Map<Integer, TreeNode> children;

    public TreeNode() {
      this.children = new HashMap<>();
      this.klass = -1;
    }
  }
}
