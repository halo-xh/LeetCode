package com.xh.others;

import java.util.Arrays;

/**
 * author  Xiao Hong
 * date  2021/4/12 20:52
 * <p>
 * https://leetcode-cn.com/problems/largest-number/solution/
 * [3,30,34,5,9]
 */

public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String largestNumber(int[] nums) {
        StringBuilder a = new StringBuilder();
        for (int num : nums) {
            a.append(num);
        }
        int length = a.length();
        int[] newints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newints[i] = nums[i];
            while (newints[i] != 0 && (length - String.valueOf(newints[i]).length()) != 0) {
                newints[i] *= 10;
            }
        }
        Arrays.sort(newints);
        System.out.println(Arrays.toString(newints));
        int res = newints[newints.length - 1];
        int v = 1;
        for (int i = newints.length - 2; i >= 0; i--) {
            System.out.println("res = " + res);
            res += (newints[i] / 10 * v++);
        }
        return String.valueOf(res);
    }

    public String largestNumber2(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }

}
