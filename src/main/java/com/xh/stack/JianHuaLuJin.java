package com.xh.stack;

import java.util.LinkedList;

/**
 * author  Xiao Hong
 * date  2020/9/21 23:07
 * description
 * <p>
 * https://leetcode-cn.com/problems/simplify-path/
 */

public class JianHuaLuJin {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : split) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                if (!s.equals(".") && !s.equals("")) {
                    stack.push(s);
                }
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append("/").append(stack.removeLast());
        }
        return stringBuilder.toString();
    }
}
