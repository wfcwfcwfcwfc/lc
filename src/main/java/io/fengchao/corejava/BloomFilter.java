package io.fengchao.corejava;

import java.util.HashSet;
import java.util.Set;

public class BloomFilter {

    private static int BITS = 32;

    private int hashfunc(int x, int i) {
        return (int)((x + Math.pow(x, i)) % BITS);
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter();
        System.out.println(bloomFilter.calculateFirstFalsePositive(2016));
    }

    private int calculateFirstFalsePositive(int start) {
        int[] bf = new int[BITS];
        int num = start;
        while(true) {
            Set<Integer> set = new HashSet<>();
            for(int pos = 1; pos <=4; pos++) {
                set.add(hashfunc(num, pos));

            }
            for(Integer p : set) {
                if(bf[p] != 0){
                    return num;
                } else {
                    bf[p] = 1;
                }
            }
            num++;
        }
    }

}
