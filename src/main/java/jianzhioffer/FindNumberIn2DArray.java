package jianzhioffer;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 12:49
 * <p>
 * 二维数组中的查找
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 */
public class FindNumberIn2DArray {

    /**
     * 二分查找
     *
     * @param matrix 矩阵
     * @param target 目标数字
     * @return 存在否
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length==0){
            return false;
        }
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        int x = 0, y = xlen-1;// 左下角开始
        while (x< ylen && y >=0){
            int i = matrix[y][x];
            System.out.println(i);
            if (i == target){
                return true;
            }else if (target > i){
                x ++;
            }else {
                y --;
            }
        }
        return false;

    }
}
