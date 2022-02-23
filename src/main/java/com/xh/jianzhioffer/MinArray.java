package com.xh.jianzhioffer;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 16:58
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 */
public class MinArray {

    public int minArray(int[] numbers) {
        int length = numbers.length;
        if (numbers[0] >= numbers[length - 1]) {
            for (int i = length - 1; i > 0; i--) {
                if (numbers[i - 1] > numbers[i]) {
                    return numbers[i];
                }
            }
        }
        return numbers[0];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] res = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[l1][l2];
    }

    public static void main(String[] args) {
        String text1 = "bsbininm", text2 = "jmjkbkjkv";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

}
