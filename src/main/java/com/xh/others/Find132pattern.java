package com.xh.others;

import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/24 9:12
 * <p>
 * https://leetcode-cn.com/problems/132-pattern/submissions/
 */
public class Find132pattern {

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
    }

    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
}