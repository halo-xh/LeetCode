package com.xh.dp.linerDp;

import java.util.*;

/**
 * Created by Xiao Hong on 2021-11-11
 * </p>
 * https://github.com/SharingSource/LogicStack-LeetCode/wiki/%E7%BA%BF%E6%80%A7-DP
 */
public class DP1111 {

    /**
     * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
     * <p>
     * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
     * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
     * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
     * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
     * 返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
     * <p>
     * 输出：3
     * <p>
     * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
     * <p>
     * 示例 2：
     * <p>
     * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
     * <p>
     * 输出：0
     * <p>
     * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
     * <p>
     * 限制：
     * <p>
     * 2 <= n <= 10
     * 1 <= k <= 5
     * 1 <= relation.length <= 90, 且 relation[i].length == 2
     * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
     * <p>
     * https://leetcode-cn.com/problems/chuan-di-xin-xi/
     */
    public static int numWaysBFS(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> routeMap = new HashMap<>(relation.length);
        for (int[] ints : relation) {
            Set<Integer> dest = routeMap.getOrDefault(ints[0], new HashSet<>());
            dest.add(ints[1]);
            routeMap.put(ints[0], dest);
        }
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(0);
        int levelSize = 1;
        while (!deque.isEmpty() && k >= 0) {
            Integer pop = deque.pop();
            levelSize--;
            if (0 == k && (pop == n - 1)) {
                count++;
            }
            Set<Integer> integers = routeMap.get(pop);
            if (integers != null) {
                integers.forEach(deque::addLast);
            }
            if (levelSize == 0) {
                levelSize = deque.size();
                k--;
            }
        }
        return count;
    }

    static int res = 0;

    public static int numWaysDFS(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> routeMap = new HashMap<>(relation.length);
        for (int[] ints : relation) {
            Set<Integer> dest = routeMap.getOrDefault(ints[0], new HashSet<>());
            dest.add(ints[1]);
            routeMap.put(ints[0], dest);
        }
        dfs(n, routeMap, 0, k);
        return res;
    }


    public static void dfs(int n, Map<Integer, Set<Integer>> routeMap, int cur, int k) {
        if (k == 0 && (cur == n - 1)) {
            res++;
        }
        if (k > 0) {
            Set<Integer> integers = routeMap.get(cur);
            if (integers != null) {
                for (Integer integer : integers) {
                    dfs(n, routeMap, integer, k - 1);
                }
            }
        }
    }

    /**
     * 邻接矩阵 DFS
     */
    static int res2 = 0;

    public static int numWaysDFSMatrix(int n, int[][] relation, int k) {
        int[][] routeArr = new int[n][n];
        for (int[] ints : relation) {
            int lo = ints[0];
            int dest = ints[1];
            Arrays.fill(routeArr[lo], -1);
            routeArr[lo][dest] = 1;
        }

        dfs(n, routeArr, 0, k);
        return res2;
    }

    public static void dfs(int n, int[][] routeMap, int cur, int k) {
        if (k == 0 && cur == n - 1) {
            res2++;
        }
        if (k > 0) {
            int[] ints = routeMap[cur];
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1) {
                    dfs(n, routeMap, i, k - 1);
                }
            }
        }
    }

    /**
     * dp[k][n] = sum (dp[k-1][map(n)])
     */
    public static int numWaysDP(int n, int[][] relation, int k) {
        int length = relation.length;
        int[][] dp = new int[k + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] ints : relation) {
                int orin = ints[0];
                int dest = ints[1];
                dp[i][dest] += dp[i - 1][orin];
            }
        }
        return dp[k][n - 1];
    }


    /**
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
     */
    public static int fib(int n) {
        int f1 = 0;
        int f2 = 1;
        for (int i = 0; i < n; i++) {
            int res = (f2 + f1) % 1000000007;
            f1 = f2;
            f2 = res;
        }
        return f1;
    }


    /**
     * https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended-ii/
     */
    public static int maxValue(int[][] events, int k) {
        int elen = events.length;
        int[][] dp = new int[elen + 1][k + 1];
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));
        for (int j = 1; j <= elen; j++) {
            int start = events[j - 1][0];
            int val = events[j - 1][2];

            int formerEnd = 0;
            for (int i = j - 2; i >= 0; i--) {
                if (events[i][1] < start) {
                    formerEnd = i + 1;
                    break;
                }
            }

//            for (int p = j - 1; p >= 1; p--) {
//                int[] prev = events[p - 1];
//                if (prev[1] < start) {
//                    formerEnd = p;
//                    break;
//                }
//            }

            for (int i = 1; i <= k; i++) {
                dp[j][i] = Math.max(dp[formerEnd][i - 1] + val, dp[j - 1][i]);
            }
        }
        return dp[elen][k];
    }


    public static void main(String[] args) {
//        int i = numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3);
//        int i = numWaysDFSMatrix(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3);
//        System.out.println("i = " + i);
//        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(maxSubArray(ints));
        int[][] arr = new int[][]{{1, 3, 4}, {2, 4, 1}, {1, 1, 4}, {3, 5, 1}, {2, 5, 5}};
        System.out.println(maxValue(arr, 3));
    }


}
