package com.xh.others;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author  Xiao Hong
 * date  2021/5/2 18:42
 * <p>
 * https://leetcode-cn.com/problems/brick-wall/
 */

public class LeastBricks {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>() {{
            add(1);
        }});
        lists.add(new ArrayList<Integer>() {{
            add(1);
        }});
        lists.add(new ArrayList<Integer>() {{
            add(1);
        }});
        LeastBricks leastBricks = new LeastBricks();
        System.out.println("leastBricks.leastBricks(lists) = " + leastBricks.leastBricks(lists));
    }

    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, sum = 0; i < n; i++, sum = 0) {
            for (int cur : wall.get(i)) {
                sum += cur;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum); // 不能从两边穿过，需要 remove 掉最后一个
        }
        int ans = n;
        for (int u : map.keySet()) {
            int cnt = map.get(u);
            ans = Math.min(ans, n - cnt);
        }
        return ans;
    }
}
