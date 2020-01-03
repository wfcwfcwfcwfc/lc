package io.fengchao.leetcode.problems;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        solution2.coinChange(coins, amount);
    }
}


class Solution2 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int result = helper(coins, amount, coins.length - 1, 0);
        return result;
    }

    private int helper(int[] coins, int amount, int pos, int counter) {
        if(amount == 0) {
            return counter;
        }
        if(amount < 0) {
            System.out.println("   ");
            return -1;
        }
        for(int i = pos; i >= 0; i--) {
            System.out.print(coins[i] + ",");
            int val = helper(coins, amount - coins[i], pos, counter + 1);
            if(val > 0) {
                return val;
            }
        }
        return -1;
    }
}