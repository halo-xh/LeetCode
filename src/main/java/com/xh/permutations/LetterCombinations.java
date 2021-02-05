package com.xh.permutations;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/5 17:04
 * @description https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return Collections.emptyList();
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        char[] chars = digits.toCharArray();
        Stack<String> stk1 = new Stack<>();
        Stack<String> stk2 = new Stack<>();
        List<String> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(phoneMap.get(aChar));
        }
        stk1.push()

    }

    public List<String> dfs(List<String> res, String rs, char[] chars) {
        for (String re : res) {
            for (char aChar : chars) {
                res.add(rs + aChar);
            }
        }
        return res;
    }

}
