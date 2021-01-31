package com.xh.bit;

import java.util.Arrays;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 */
public class DuplicateAndMiss {


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 4, 5, 7};
        System.out.println(Arrays.toString(findErrorNums(ints)));
        System.out.println(Arrays.toString(findErrorNums2(ints)));
    }

    public static int[] findErrorNums(int[] nums) {
        // step1 缺失值和重复值的抑或结果 Duplicate ^ Miss
        // 10011 ^ 00111 = 10100
        int res2 = 0, res1 = 0, DorM = 0;
        for (int i = 1; i <= nums.length; i++) {
            DorM ^= i;
            DorM ^= nums[i - 1];

        }
        // step2 区分 缺失值和重复值
        // step2.1  根据缺失值和重复值的某二进制位为 1 将 nums 分组
        int index = DorM & -DorM;
        System.out.println(index);
        for (int i = 1; i <= nums.length; i++) {
            if ((index & i) == 0) {
                res1 ^= i;
            } else {
                res2 ^= i;
            }
            if ((index & nums[i - 1]) == 0) {
                res1 ^= nums[i - 1];
            } else {
                res2 ^= nums[i - 1];
            }
        }
        for (int num : nums) {
            if (num == res1) { // 重复
                return new int[]{res1, res2};
            }
        }
        return new int[]{res2, res1};
    }

    public static int[] findErrorNums2(int[] nums) {
        int[] map = new int[nums.length];
        int duplciate = 0;
        int miss = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map[i] != 0) {
                duplciate = map[i];
            }
            map[i] = 1;
        }
        for (int i : map) {
            if (i == 0) {
                miss = i;
            }
        }
        return new int[]{duplciate, miss};
    }

}
