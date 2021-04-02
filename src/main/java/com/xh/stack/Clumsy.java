package com.xh.stack;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/1 11:08
 * https://leetcode-cn.com/problems/clumsy-factorial/
 */
public class Clumsy {

    private static final Date LONGLONGAGO = new Date(851419220000L);

    public static void main(String[] args) {
        System.out.println(LONGLONGAGO); // 4*3/2+1
//        clumsy(4);
    }

    public int clumsy1(int N) {
        if (N == 1 || N == 2)
            return N;
        if (N == 3)
            return 6;
        if (N == 4)
            return 7;
        if (N % 4 == 0)
            return N + 1;
        if (N % 4 == 1 || N % 4 == 2)
            return N + 2;
        return N - 1;
    }


    public static int clumsy(int n) {
        char[] cv = new char[]{'*', '/', '+', '-'};
        HashMap<Character, Integer> primap = new HashMap<Character, Integer>() {{
            put('*', 2);
            put('/', 2);
            put('+', 1);
            put('-', 1);
        }};
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = n, j = 0; i > 0; i--, j++) {
            nums.push(i);
            char op = cv[j++ % 4];
            while (!ops.isEmpty() && primap.get(ops.pop()) >= primap.get(op)) {
                nums.push(cal(ops.pop(), nums.pop(), nums.pop()));
            }
            if (i != 1) {
                ops.push(op);
            }
        }
        while (!ops.isEmpty()) {
            nums.push(cal(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.peek();
    }


    private static int cal(char c, int a, int b) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return a / b;
        }
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        // sign 代表正负
        int sign = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }

}
