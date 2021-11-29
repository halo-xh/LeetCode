package com.xh.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/7/19 17:06
 * <p>
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class CheckInclusion {


    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int length = s2.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] s1chars = s1.toCharArray();
        int s1Len = s1chars.length;
        for (char c : s1chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (right < length) {
            char c = s2.charAt(right);
            right++;
            Integer integer = map.get(c);
            if (integer != null && integer > 0) {
                map.put(c, integer - 1);
                s1Len--;
                if (s1Len == 0) {
                    return true;
                }
            }
            while (right - left >= s1.length()) {

            }


        }

        return true;
    }

    /**
     * https://leetcode-cn.com/problems/palindrome-number/
     */
    public static boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        int length = value.length();
        for (int i = 0; i < length / 2; i++) {
            if (value.charAt(i) != value.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/longest-common-prefix/
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        String flag = null;
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
                flag = str;
            }
        }
        if (flag == null) {
            return res.toString();
        }
        for (int i = 0; i < flag.toCharArray().length; i++) {
            Character c = null;
            for (String str : strs) {
                c = str.charAt(i);
                if (c != flag.charAt(i)) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }

    /**
     * https://leetcode-cn.com/problems/search-insert-position/
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int i = searchInsert(arr, 3);
        System.out.println("i = " + i);

    }


}
