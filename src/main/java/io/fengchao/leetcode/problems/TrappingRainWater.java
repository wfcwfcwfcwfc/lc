package io.fengchao.leetcode.problems;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] in = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int out = trappingRainWater.trap(in);
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lm = 0;
        int rm = 0;

        int sum = 0;

        while(l < r) {
            if(lm < rm) {
                int diff = lm - height[l];
                sum += diff > 0 ? diff : 0;
                lm = Math.max(lm, height[l]);
                l++;
            } else {
                int diff = rm - height[r];
                rm = Math.max(rm, height[r]);
                sum += diff > 0 ? diff : 0;
                r--;
            }
        }
        return sum;

    }
}
