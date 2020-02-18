package io.fengchao.uiuc.cs412;

import java.io.*;
import java.util.*;

public class Apriori {
    public static void main(String[] args) {
        part1();


    }

    private static void part1() {
        File file = new File("/Users/fenwang/Downloads/categories.txt");
        List<String> list = readFileToList(file);
        System.out.println(list);

        Map<String, Integer> freqMap = new HashMap<>();
        for(String line : list) {
            String[] words = line.split(";");
            for(String word : words) {
                freqMap.putIfAbsent(word, 0);
                freqMap.put(word, freqMap.get(word) + 1);
            }
        }

        List<String> supportColonCategory = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 771) {
                supportColonCategory.add(entry.getValue() + ":" + entry.getKey());
            }
        }

        Collections.sort(supportColonCategory, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int v1 = Integer.valueOf(o1.split(":")[0]);
                int v2 = Integer.valueOf(o2.split(":")[0]);

                return v2 - v1;
            }
        });


        System.out.println(supportColonCategory);


        writeToFile(supportColonCategory, new File("part1.txt"));

    }

//    /**
//     * Apriori algorithm. Association.
//     * 1. Initialize
//     * 2. Generate next level of sets. Group by first k - 1 chars, then concat last char with each of the element.
//     * 3. Remove candidates. Generate k char subsets
//     * @return
//     */
//    private static List<String> part2() {
//        //Read file
//
//
//        //Init freq map
//        Map<String, Integer> freqMap = new HashMap<>();
//
//        Queue<String> queue = new LinkedList<>();
//
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            List<String> candidate = new ArrayList<>();
//            List<String> f = new ArrayList<>();
//
//        }
//
//
//
//    }
//
//    private static Set<String> getSubsets(String word){
//
//    }



    private static List<String> readFileToList(File file) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static void writeToFile(List<String> list, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for(String line: list) {
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
