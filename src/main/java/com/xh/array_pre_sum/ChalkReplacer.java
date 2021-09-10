package com.xh.array_pre_sum;

/**
 * Created by Xiao Hong on 2021-09-10
 * </p>
 * https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 */
public class ChalkReplacer {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;// 精度问题 int不行
        for (int i : chalk) {
            sum += i;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return -1;
    }
}
