package com.xh.window;

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
}
