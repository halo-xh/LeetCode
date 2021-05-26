package com.xh.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/26 9:08
 * <p>
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class ReverseParentheses {

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
