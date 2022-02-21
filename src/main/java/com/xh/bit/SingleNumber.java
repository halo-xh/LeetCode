package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/30 9:01
 * <p>
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    /**
     * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
     */
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }


}
