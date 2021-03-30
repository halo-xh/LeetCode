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
                {5, 4}, {6, 4}};
        System.out.println(maxEnvelopes(ar));
    }

    /**
     * 1. 排序： 按照第一个值升序排列，如果相同则第二个值升序
     * 2. 最长升序子数组
     */
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
            int[] cur = collect.get(i);
            for (int j = 0; j < i; j++) {
                int[] ft = collect.get(j);
                if (ft[0] < cur[0] && ft[1] < cur[1]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
            max = Math.max(res[i], max);

        }
        return max;
    }

}


