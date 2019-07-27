package io.fengchao.corejava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] array = new int[]{3, 4, 5, 1};

        set.add(1);
        set.add(2);
        set.add(array[3]);

        set.contains(1);
        set.contains(3);

        set.add(new Integer(8));
        set.contains(8);

        int[] result = set.stream().mapToInt(Number::intValue).toArray();

        Map<String, String> map = new HashMap<>();
//        map.computeIfAbsent();
    }
}
