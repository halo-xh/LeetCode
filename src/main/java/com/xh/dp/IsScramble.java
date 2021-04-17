package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2021/4/16 21:52
 * description
 */

public class IsScramble {

    public boolean isScramble(String s1, String s2) {
        return getaBoolean(s1, s2);
    }

    private boolean getaBoolean(String s1, String s2) {
        if (s1.equals(s2)) return true;
        for (char c : s1.toCharArray()) {
            if (!s2.contains(String.valueOf(c))) return false;
        }
        int length = s1.toCharArray().length;
        for (int i = 0; i < length; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, 0), s2.substring(i, 0))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(i, length)) && isScramble(s1.substring(i, length), s2.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
