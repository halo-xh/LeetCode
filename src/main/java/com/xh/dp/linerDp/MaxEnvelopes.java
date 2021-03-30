package com.xh.dp.linerDp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/4 20:58
 * <p>
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        int[][] ar = new int[][]{
                {5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(ar));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        List<int[]> collect = Stream.of(envelopes).sorted((x1, x2) -> {
            if (x1[0] > x2[0]) {
                return 1;
            } else if (x1[0] == x2[0]) {
                return x1[1] > x2[1] ? 1 : -1;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());
        int[] res = new int[collect.size()];
        Arrays.fill(res, 1);
        int max = 1;
        for (int i = 1; i < collect.size(); i++) {


        }
        return max;
    }

}


