package com.xh.dp;

import com.xh.tree.TreeNode;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/7/1 9:32
 * @description https://leetcode-cn.com/problems/chuan-di-xin-xi
 * <p>
 * <p>
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
 * DFS BFS DP
 */
public class NumWays2 {


    public int numWays(int n, int[][] relation, int k) {
        // dp[][] 记录 经过 i 次 走到 j 的方案数
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        // 走k步
        for (int i = 0; i < k; i++) {
            // 路线关系
            for (int[] map : relation) {
                // 出发地
                int src = map[0];
                // 目的地
                int dest = map[1];
                // 下一步到目的地dest的方案数 等于 这一步到能够到且下一步目的地为dest的方案数和
                dp[i + 1][dest] += dp[i][src];
            }
        }
        // 返回 k 次 走到 n 的方案数
        return dp[k][n - 1];
    }

    // todo dfs
    public int numWays3(int n, int[][] relation, int k) {
        // 构造出发点和目的地集合映射
        Map<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int[] maps : relation) {
            int src = maps[0];
            int dest = maps[1];
            Set<Integer> canArriveDest = routeMap.getOrDefault(src, new HashSet<>());
            canArriveDest.add(dest);
            routeMap.put(src, canArriveDest);
        }
        // start dfs.
        int count = 0;
        int l = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop == n - 1 && l == k) {
                count++;
                continue;
            }
            Set<Integer> integers = routeMap.get(pop);
            if (integers != null) {
                l++;
                for (Integer integer : integers) {
                    stack.push(integer);
                }
            }

        }

        return count;
    }

    /**
     *           if (c == k_) {
     *             if (dest == n_ - 1) {
     *                 this.count++;
     *             }
     *             return;
     *         }
     *         Set<Integer> integers = routeMap.get(dest);
     *         if (integers == null) {
     *             return;
     *         }
     *         for (Integer integer : integers) {
     *             dfs(routeMap, integer, c + 1);
     *         }
     *
     *
     */

    /**
     * DFS . 递归版。
     */
    int count = 0;
    int k_ = 0;
    int n_ = 0;

    public int numWays4(int n, int[][] relation, int k) {
        this.k_ = k;
        this.n_ = n;
        // 构造出发点和目的地集合映射
        Map<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int[] maps : relation) {
            int src = maps[0];
            int dest = maps[1];
            Set<Integer> canArriveDest = routeMap.getOrDefault(src, new HashSet<>());
            canArriveDest.add(dest);
            routeMap.put(src, canArriveDest);
        }
        dfs(routeMap, 0, 0);
        return count;
    }

    private void dfs(Map<Integer, Set<Integer>> routeMap, int dest, int c) {
        if (c == k_) {
            if (dest == n_ - 1) {
                this.count++;
            }
            return;
        }
        Set<Integer> integers = routeMap.get(dest);
        if (integers == null) {
            return;
        }
        for (Integer integer : integers) {
            dfs(routeMap, integer, c + 1);
        }

    }

    /**
     * my bfs. 类似层序遍历。 不管是不是 就走k层 是不是结果最后判断
     */
    public int numWays23(int n, int[][] relation, int k) {
        // 构造出发点和目的地集合映射
        Map<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int[] maps : relation) {
            int src = maps[0];
            int dest = maps[1];
            Set<Integer> canArriveDest = routeMap.getOrDefault(src, new HashSet<>());
            canArriveDest.add(dest);
            routeMap.put(src, canArriveDest);
        }
        // deque. 队列
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        // 和二叉树的层序遍历是一样的。。 这里只需要遍历k层
        while (!deque.isEmpty() && k-- > 0) {
            int levelSize = deque.size();
            while (levelSize-- > 0) {
                Integer pollFirst = deque.pollFirst();
                Set<Integer> routes = routeMap.get(pollFirst);
                // 走到绝路了。。。。。
                if (routes == null) {
                    continue;
                }
                // 把所有目的地加入到下一层（二叉树遍历是加的左右子节点）
                for (Integer route : routes) {
                    deque.addLast(route);
                }
            }
        }
        // 这个时候deque就是走了k层后可以到达的值集合
        // 遍历是不是最终想要的目的地n-1即可
        int count = 0;
        for (Integer integer : deque) {
            if (integer == n - 1) {
                count++;
            }
        }
        return count;

    }

}
