package io.fengchao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SfOptimization {
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution() throws IOException {
        Path path = Paths.get("/Users/fengchaowang/Downloads/result.csv");


        List<String[]> read = Files.readAllLines(path)
                .stream().map(row -> row.split(","))
                .map(row-> new String[]{row[2], row[4]}).collect(Collectors.toList());

        Map<String, List<String>> map = new HashMap<>();

        for(String[] pair : read) {
            map.computeIfAbsent(pair[0], k -> new ArrayList<String>()).add(pair[1]);
        }



        map.values().stream().forEach(list -> {
                    Set<String> set = new HashSet<>(list);
            list.clear();
            list.addAll(set);
        });

        calculateShortestPathFromSource(map);


    }

    public static void calculateShortestPathFromSource(Map<String, List<String>> graph) {

        List<String> processedDeps = new ArrayList<>();
        List<String> processedApps = new ArrayList<>();
        List<Integer> length = new ArrayList<Integer>();

        while (graph.size() != 0) {
            Map.Entry<String, List<String>> currentNode = getLowestDistanceNode(graph);
            graph.remove(currentNode.getKey());

            processedApps.add(currentNode.getKey());
            processedDeps.addAll(currentNode.getValue());
            length.add(currentNode.getValue().size());

            updateMinimumDistance(graph, currentNode.getValue());

            for(String str : currentNode.getValue()) {
                System.out.println(str);
            }

            System.out.println("," + currentNode.getKey());

            }

        printResults(processedApps, length);
    }

    private static Map.Entry<String, List<String>> getLowestDistanceNode(Map<String, List<String>> unsettled) {
        int min = Integer.MAX_VALUE;
        Map.Entry<String, List<String>> res = null;
        for(Map.Entry<String, List<String>> entry : unsettled.entrySet()) {
            if(entry.getValue().size() < min) {
                res = entry;
                min = entry.getValue().size();
            }
        }
        return res;
    }

    private static void updateMinimumDistance(Map<String, List<String>> unsettled, List<String> tableList) {
        for(Map.Entry<String, List<String>> entry : unsettled.entrySet()) {
            entry.getValue().removeAll(tableList);
        }
    }

    private static void printResults(List<String> apps, List<Integer> length) {
        for(int i = 0; i < apps.size(); i++) {
            System.out.println(apps.get(i) + ", " + length.get(i));
        }

        int sum = 0;
        for(int num : length) {
            sum = sum + num;
        }
        System.out.println("Minimized waiting time is: " + sum);

    }

}
