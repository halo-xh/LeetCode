package dp;

/**
 * author  Xiao Hong
 * date  2020/9/20 21:54
 * description
 * <p>
 * ******** dp2 的 变形*******
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 输入:
 * {
 *   {0,0,0},
 *   {0,1,0},
 *   {0,0,0}
 * }
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class WangGeLuJin2 {

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};

        System.out.println(improve(arr)[2][2]);
    }

    /**
     * 改一下试试
     * 用二维数组 存值
     */
    public static int[][] improve(int[][] obstacleGrid) {
        for (int k = 0; k < obstacleGrid.length; k++) {
            for (int l = 0; l < obstacleGrid[0].length; l++) {
                if (obstacleGrid[k][l] == 1) {
                    obstacleGrid[k][l] = 0;
                } else if (k == 0 && l == 0) {
                    obstacleGrid[k][l] = 1;
                } else if (k == 0) {
                    obstacleGrid[k][l] = obstacleGrid[k][l - 1];//精髓哈哈哈 我好像也还可以？
                } else if (l == 0) {
                    obstacleGrid[k][l] = obstacleGrid[k - 1][l];
                } else {
                    obstacleGrid[k][l] = obstacleGrid[k - 1][l] + obstacleGrid[k][l - 1];
                }
            }
        }
        return obstacleGrid;
    }
}
