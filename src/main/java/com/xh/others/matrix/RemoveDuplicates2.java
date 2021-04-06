package com.xh.others.matrix;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/6 10:51
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int n =0;
        for (int num : nums) {
            if (n<1 || nums[n-1] != num){
                nums[n++] = num;
            }
        }
        return n;
    }
}
