package com.xh.others;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/20 12:41
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrStr {

    public static void main(String[] args) {
        //= "hello", needle = "ll"
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("aaa", "aaaa"));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        if (haystack.length()<needle.length()){
            return -1;
        }
        char[] chars = haystack.toCharArray();
        char[] neddles = needle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == neddles[0] && same(i,chars,neddles)){
                return i;
            }
        }
        return -1;
    }

    private boolean same(int i, char[] chars, char[] neddles) {
        if (chars.length - i <neddles.length){
            return false;
        }
        for (int j = 0; j < neddles.length; j++) {
            if (neddles[j] != chars[i+j]){
                return false;
            }
        }
        return true;
    }

    //todo . KMP

}
