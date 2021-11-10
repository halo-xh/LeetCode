package com.xh.others;

/**
 * author  Xiao Hong
 * date  2021/11/10 20:57
 * description https://leetcode-cn.com/problems/teemo-attacking/submissions/
 */

public class FindPoisonedDuration {

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 1) {
            return duration;
        }
        int total = timeSeries.length * duration;
        int duplicate = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int i1 = timeSeries[i] - timeSeries[i - 1];
            if (i1 < duration) {
                duplicate += (duration - i1);
            }
        }
        return total - duplicate;
    }

}
