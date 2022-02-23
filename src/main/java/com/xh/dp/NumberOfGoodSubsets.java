package com.xh.dp;

/**
 * @author xiaohong
 * @date 2022/2/22 15:25
 * <p>
 * https://leetcode-cn.com/problems/the-number-of-good-subsets/submissions/
 **/
public class NumberOfGoodSubsets {


    public int numberOfGoodSubsets(int[] nums) {

        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-only-letters/
     */
    public static String reverseOnlyLetters(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (!Character.isLetter(chars[i]) && i < j) i++;
            while (!Character.isLetter(chars[j]) && i < j) j--;
            if (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

}