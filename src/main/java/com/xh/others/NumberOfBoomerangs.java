package com.xh.others;

import java.util.HashMap;
import java.util.Map;

/**
 * author  Xiao Hong
 * date  2021/9/13 23:03
 * description
 * <p>
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 * 统计两两之间的距离，用map存起来。
 */

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] ints : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] point : points) {
                int x = ints[0] - point[0];
                int y = ints[1] - point[1];
                int dist = x * x + y * y;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            // 排列组合 有序A(n,2)
            for (Integer integer : map.keySet()) {
                int count = map.get(integer);
                ans += count * (count - 1);
            }
            map.clear();
        }
        return ans;
    }

}
