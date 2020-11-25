package dp;

/**
 * author  Xiao Hong
 * date  2020/9/20 20:56
 * description
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class WangGeLuJin {

    public static void main(String[] args) {
        System.out.println(getWays(7, 3));
        System.out.println(improve(7, 3));

    }

    /**
     * 只能向下或者向右所以在 i-1,j 或者 i,j-1 时 只有一种方法，
     * 所以状态转移方程为： opt[i][j] = opt[i-1][j]+ opt[i][j-1]
     * <p>
     * 结果： 超时、 很明显多算了很多 <>重叠子问题</>
     */
    public static int getWays(int i, int j) {
        if (i < 1 || j < 1) {
            return 0;
        }
        if (i == 1 && j == 1) {
            return 1;
        }
        return getWays(i - 1, j) + getWays(i, j - 1);
    }

    /**
     * 用二维数组 存值
     * 注意。  if (k == 0 || l == 0) world[k][l] = 1; 这里小卡一下
     */
    public static int improve(int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        int[][] world = new int[m][n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (k == 0 || l == 0) {
                    world[k][l] = 1;
                } else {
                    world[k][l] = world[k - 1][l] + world[k][l - 1];
                }
            }
        }
        return world[m - 1][n - 1];
    }


}
