package com.xh.dp.linerDp;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.*;

/**
 * Created by Xiao Hong on 2021-11-11
 * </p>
 * https://github.com/SharingSource/LogicStack-LeetCode/wiki/%E7%BA%BF%E6%80%A7-DP
 */
public class DP1111 {

    /**
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

    /**
     * https://leetcode-cn.com/problems/decode-ways-ii/
     */
    public int numDecodings(String s) {
        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/counting-bits/
     */
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int k = i;
            while (k != 0) {
                count += (k & 1);
                k = k >> 1;
            }
            res[i] = count;
        }
        return res;
    }

    // ref:https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
    public static int[] countBits2(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 0) { // 偶数
                res[i] = res[i >> 1];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/pascals-triangle-ii/
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }
        int[][] res = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j <= i; j++) {
                if ((j == 0) || (j == i)) {
                    res[i][j] = 1;
                    continue;
                }
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        }
        List<Integer> re = new ArrayList<>(res[rowIndex - 1].length);
        for (int i : res[rowIndex]) {
            re.add(i);
        }
        return re;
    }

    public List<Integer> getRow2(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }
        int[] res = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if ((j == 0) || (j == i)) {
                    res[i] = 1;
                    continue;
                }
                res[j] += res[j - 1];
            }
        }
        List<Integer> re = new ArrayList<>(res.length);
        for (int i : res) {
            re.add(i);
        }
        return re;
    }

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     */
    public static int jumpBFS(int[] nums) {
        int length = nums.length;
        int[][] routArr = new int[length][length];
        // build route arr
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            for (int j = i; j <= num + i && j < length; j++) {
                routArr[i][j] = 1;
            }
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        int min = Integer.MAX_VALUE;
        int count = 0;
        int levelSize = 1;
        while (!deque.isEmpty()) {
            Integer pop = deque.pop();
            int[] ints = routArr[pop];
            levelSize--;
            if (pop == length - 1) {
                count++;
                min = Math.min(count, min);
                break;
            }
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1 && i > pop) {
                    deque.addLast(i);
                }
            }
            if (levelSize == 0) {
                levelSize = deque.size();
            }
        }
        return min;
    }

    public static int jump(int[] nums) {
        int maxPos = 0;   // 纪录位置 i 可以跳到的最远距离
        int end = 0;      // 纪录位置本次跳跃可以抵达的右边界
        int step = 0;     // 纪录跳跃次数
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);   // 先计算位置 i 可以跳跃的最远距离
            if (i == end) {  // i == end 表示本次跳跃的所有可能都已经尝试, 那么就需要更新 end 和 step
                end = maxPos;
                step++;
            }
        }
        return step;
    }

    /**
     * https://leetcode-cn.com/problems/out-of-boundary-paths/
     */
    public int findPathsdp(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] res = new int[m + 1][n + 1];


        return 0;
    }

    int fpres = 0;

    public int findPathsdfs(int m, int n, int maxMove, int startRow, int startColumn) {
        fpdfs(startRow, startColumn, m, n, maxMove);
        return fpres;
    }

    public void fpdfs(int start, int end, int m, int n, int k) {
        if (k == 0) {
            return;
        }
        if (start == 0 || end == 0 || start == m || end == n) {
            fpres++;
        }
        for (int i = start; i <= m; i++) {
            for (int j = end; j <= n; j++) {
                fpdfs(i, j, m, n, k - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(arr));
    }


}
