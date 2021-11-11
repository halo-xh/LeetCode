package com.xh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/10/19 21:44
 * description
 */

public class DP_1019 {


    public static int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtwu06/
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                } else if (i > 0) {
                    res[i][j] = res[i - 1][j];
                } else if (j > 0) {
                    res[i][j] = res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }


    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rt1hg6/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] res = new int[x][y];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        res[0][0] = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i > 0 && j > 0) {
                        res[i][j] = res[i - 1][j] + res[i][j - 1];
                    } else if (i > 0) {
                        res[i][j] = res[i - 1][j];
                    } else if (j > 0) {
                        res[i][j] = res[i][j - 1];
                    }
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res[x - 1][y - 1];
    }


    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtcz3i/
     */
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] res = new int[x][y];
        res[0][0] = grid[0][0];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i > 0 && j > 0) {
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                }
            }
        }
        return res[x - 1][y - 1];
    }

    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtfiiv/
     * <p>
     * O(n^2 )
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int ans = Integer.MAX_VALUE;
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                if (j != i) f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
            }
        }
        for (int i = 0; i < n; i++) ans = Math.min(ans, f[n - 1][i]);
        return ans;
    }

    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r85adr/
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]), matrix[i - 1][j - 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : matrix[n - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r8oh2h/
     */
    // O(n^3)
    public int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = grid[i][j] + getMin(grid[i - 1], j);
            }
        }
        return getMin(grid[n - 1], -1);
    }

    private static int getMin(int[] arr, int index) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                min = Math.min(min, arr[i]);
            }
        }
        return min;
    }

    // O(n^2)
    public static int minFallingPathSum3(int[][] grid) {
        int n = grid.length;
        int first_sum = 0, first_pos = -1, second_sum = 0;
        for (int[] ints : grid) {
            int fs = Integer.MAX_VALUE, fp = -1, ss = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                int cur_sum = (first_pos != j ? first_sum : second_sum) + ints[j];
                if (cur_sum < fs) {
                    ss = fs;
                    fs = cur_sum;
                    fp = j;
                } else if (cur_sum < ss) {
                    ss = cur_sum;
                }
            }
            first_sum = fs;
            first_pos = fp;
            second_sum = ss;
        }
        return first_sum;
    }


    // save memory
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) {
            return triangle.get(0).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> integers = triangle.get(i);
            for (int j = 0; j < integers.size(); j++) {
                if (j == 0) {
                    integers.set(j, integers.get(j) + triangle.get(i - 1).get(j));
                } else if (j == integers.size() - 1) {
                    integers.set(j, integers.get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    integers.set(j, integers.get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : triangle.get(n - 1)) {
            min = Math.min(min, integer);
        }
        return min;
    }


    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r8m6e7/
     */
    private static class Solution {
        int mod = 1000000007;
        // 缓存器：用于记录「特定状态」下的结果
        // cache[i][fuel] 代表从位置 i 出发，当前剩余的油量为 fuel 的前提下，到达目标位置的「路径数量」
        int[][] cache;

        public int countRoutes(int[] ls, int start, int end, int fuel) {
            int n = ls.length;
            // 初始化缓存器
            // 之所以要初始化为 -1
            // 是为了区分「某个状态下路径数量为 0」和「某个状态尚未没计算过」两种情况
            cache = new int[n][fuel + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cache[i], -1);
            }
            return dfs(ls, start, end, fuel);
        }

        /**
         * 计算「路径数量」
         *
         * @param ls   入参 locations
         * @param u    当前所在位置（ls 的下标）
         * @param end  目标哦位置（ls 的下标）
         * @param fuel 剩余油量
         * @return 在位置 u 出发，油量为 fuel 的前提下，到达 end 的「路径数量」
         */
        int dfs(int[] ls, int u, int end, int fuel) {
            // 如果缓存器中已经有答案，直接返回
            if (cache[u][fuel] != -1) {
                return cache[u][fuel];
            }
            int n = ls.length;
            // base case 1：如果油量为 0，且不在目标位置
            // 将结果 0 写入缓存器并返回
            if (fuel == 0 && u != end) {
                cache[u][fuel] = 0;
                return 0;
            }
            // base case 2：油量不为 0，且无法到达任何位置
            // 将结果 0 写入缓存器并返回
            boolean hasNext = false;
            for (int i = 0; i < n; i++) {
                if (i != u) {
                    int need = Math.abs(ls[u] - ls[i]);
                    if (fuel >= need) {
                        hasNext = true;
                        break;
                    }
                }
            }
            if (fuel != 0 && !hasNext) {
                cache[u][fuel] = u == end ? 1 : 0;
                return cache[u][fuel];
            }
            // 计算油量为 fuel，从位置 u 到 end 的路径数量
            // 由于每个点都可以经过多次，如果 u = end，那么本身就算一条路径
            int sum = u == end ? 1 : 0;
            for (int i = 0; i < n; i++) {
                if (i != u) {
                    int need = Math.abs(ls[i] - ls[u]);
                    if (fuel >= need) {
                        sum += dfs(ls, i, end, fuel - need);
                        sum %= mod;
                    }
                }
            }
            cache[u][fuel] = sum;
            return sum;
        }
    }

    private static class Solution2 {

        int[][] cache;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            cache = new int[locations.length][fuel];
            for (int i = 0; i < cache.length; i++) {
                Arrays.fill(cache[i], -1);
            }
            return dfs(locations, start, finish, fuel);
        }

        // cache[i][fuel]cache[i][fuel] 代表从位置 ii 出发，当前剩余的油量为 fuelfuel 的前提下，到达目标位置的「路径数量」
        public int dfs(int[] locations, int start, int finish, int fuel) {
            if (cache[start][fuel] != -1) {
                return cache[start][fuel];
            }
            // 油走光没到终点
            if (fuel == 0 && start != finish) {
                cache[start][fuel] = 0;
                return 0;
            }
            // 有油 不够去任何地方
            if (Math.abs(locations[start] - locations[finish]) > fuel) {
                cache[start][fuel] = 0;
                return 0;
            }
            int sum = (start == finish) ? 1 : 0;
            for (int i = 0; i < locations.length; i++) {
                if (i != start) {
                    int need = Math.abs(locations[i] - locations[start]);
                    if (fuel >= need) {
                        sum += dfs(locations, start, finish, fuel - need);
                        sum %= 1000000007;
                    }
                }
            }
            cache[start][fuel] = sum;
            return sum;

        }

    }


    int mod = 1000000007;

    public int countRoutes(int[] ls, int start, int end, int fuel) {
        int n = ls.length;

        // f[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
        int[][] f = new int[n][fuel + 1];

        // 对于本身位置就在目的地的状态，路径数为 1
        for (int i = 0; i <= fuel; i++) f[end][i] = 1;

        // 从状态转移方程可以发现 f[i][fuel]=f[i][fuel]+f[k][fuel-need]
        // 在计算 f[i][fuel] 的时候依赖于 f[k][fuel-need]
        // 其中 i 和 k 并无严格的大小关系
        // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
        // 因此需要先从小到大枚举油量
        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        int need = Math.abs(ls[i] - ls[k]);
                        if (cur >= need) {
                            f[i][cur] += f[k][cur - need];
                            f[i][cur] %= mod;
                        }
                    }
                }
            }
        }
        return f[start][fuel];
    }






}
