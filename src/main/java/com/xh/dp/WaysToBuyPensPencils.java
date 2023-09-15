package com.xh.dp;

import java.util.Arrays;

/**
 * @author Xiao Hong
 * @since 2023-09-01
 * <p>
 * https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/description/
 */
public class WaysToBuyPensPencils {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int x = 0; x <= total / cost1; ++x) {
            int y = (total - x * cost1) / cost2 + 1;
            ans += y;
        }
        return ans;
    }

    public static void main(String[] args) {
        giveGem(new int[]{3, 1, 2}, new int[][]{{0, 2}, {2, 1}, {2, 0}});
    }

    public static int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int val = gem[operation[0]] / 2;
            gem[operation[0]] -= val;
            gem[operation[1]] += val;
            System.out.println("gem = " + Arrays.toString(gem));
        }
        int max = gem[0], min = gem[0];
        for (int j : gem) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }
        return max - min;
    }


}
