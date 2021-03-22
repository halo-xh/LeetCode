package com.xh.stack;

import java.util.Stack;

/**
 * author  Xiao Hong
 * date  2021/3/20 21:01
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */

public class EvalRPN {

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] s = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN.evalRPN(s));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (isY(token)) {
                String n2 = stack.pop();
                String n1 = stack.pop();
                int cal = cal(n1, n2, token);
                stack.push(String.valueOf(cal));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    private boolean isY(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int cal(String n1, String n2, String c) {
        switch (c) {
            case "-":
                return Integer.parseInt(n1) - Integer.parseInt(n2);
            case "+":
                return Integer.parseInt(n1) + Integer.parseInt(n2);
            case "*":
                return Integer.parseInt(n1) * Integer.parseInt(n2);
            case "/":
                return Integer.parseInt(n1) / Integer.parseInt(n2);
        }
        return 0;
    }
}
