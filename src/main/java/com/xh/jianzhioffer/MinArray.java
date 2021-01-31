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
        if (numbers[0]>=numbers[length-1]){
            for (int i = length-1; i >0; i--) {
                if (numbers[i-1]>numbers[i]){
                    return numbers[i];
                }
            }
        }
        return numbers[0];
    }

}
