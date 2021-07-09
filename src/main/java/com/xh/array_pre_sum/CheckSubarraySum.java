package com.xh.array_pre_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/7/9 13:54
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 * <p><p/>
 * ref:https://leetcode-cn.com/problems/continuous-subarray-sum/solution/gong-shui-san-xie-tuo-zhan-wei-qiu-fang-1juse/
 */
public class CheckSubarraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(arr, 6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] sumArr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumArr[i + 1] = nums[i] + sumArr[i];
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 2; i < sumArr.length; i++) {
            hashSet.add(sumArr[i - 2] % k); // 同余
            if (hashSet.contains(sumArr[i] % k)) return true;
        }
        return false;
    }
}
