package com.xh.stack;

import java.util.*;

/**
 * author  Xiao Hong
 * date  2021/4/1 19:38
 * <p>
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * 输入：s = "3*2+2"
 * 输出：7
 * 表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
 */

public class Calculateer {

    public static void main(String[] args) {
        System.out.println(calculate("3*2+2"));
    }

    public static int calculate(String s) {
        String op = "+-*/";
        s = s.replace(" ", "");
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<String> ops = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (op.contains(String.valueOf(aChar))) {
                list.add(builder.toString());
                builder = new StringBuilder();
                list.add(String.valueOf(aChar));
            } else {
                builder.append(aChar);
            }
        }
        String pre = "+";
        for (String s1 : list) {

        }
        return 0;

    }

    private static boolean prioritier(String op1, String op2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("*", 2);
        hashMap.put("/", 2);
        hashMap.put("+", 1);
        hashMap.put("-", 1);
        return (hashMap.get(op1) - hashMap.get(op2)) >= 0;
    }


    private static int cal(String c, int a, int b) {
        switch (c) {
            case "+":
                return a + b;
            case "_":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;
        }
    }

}
