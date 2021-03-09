package com.xh.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/9 16:02
 * <p>
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择<p>两个</p>相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbbabaaa"));
        System.out.println(removeDuplicates2("abbaca"));
    }

    // error 递归 双指针 删除所有相邻的。不止两个。zzzzzz
    public static String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        if (chars.length<=1){
            return S;
        }
        if (chars.length==2){
            return chars[0]==chars[1]?"":S;
        }
        int p1 = 0;
        char current= chars[p1];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == current) {
                chars[i] = ' ';
                chars[p1] = ' ';
            }else {
                p1 = i;
                current = chars[p1];
            }
        }
        String s = String.valueOf(chars);
        return removeDuplicates(s.replace(" ",""));
    }

    // stack
    public static String removeDuplicates2(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && chars[i]==stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(chars[i]);
        }
        ArrayList<Character> characters = new ArrayList<>(stack);
        StringBuilder stringBuilder = new StringBuilder();
        characters.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
