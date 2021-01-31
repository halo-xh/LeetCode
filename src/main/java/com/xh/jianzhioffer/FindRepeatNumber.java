package com.xh.jianzhioffer;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 11:25
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int[] map = new int[nums.length];
        Arrays.fill(map, nums.length);
        for (int num : nums) {
            if (map[num] != nums.length) {
                return num;
            }
            map[num] = num;
        }
        return -1;
    }
    
    public int findRepeatNumber2(int[] nums) {
        int temp =0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i){
                temp = nums[i];
                if (nums[i] == nums[temp]){
                    return nums[i];
                }
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
    
    
}
