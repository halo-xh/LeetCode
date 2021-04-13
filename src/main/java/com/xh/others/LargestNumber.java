package com.xh.others;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/12 12:19
 * @description
 */
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
//        System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));

    }

    public String largestNumber(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        char[] chars = stringBuilder.toString().toCharArray();
        int length = chars.length;
        String format = length+"%d";
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            String s = String.format(String.valueOf(nums[i]), format);
            ints[i] = Integer.parseInt(s);
        }
        return null;
    }
}
