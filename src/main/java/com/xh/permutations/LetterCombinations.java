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

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("234"));
        System.out.println(letterCombinations.letterCombinations2("234"));
    }

    // 自己写的
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
        List<String> stk1 = new ArrayList<>();
        List<String> stk2 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(phoneMap.get(aChar));
        }
        boolean stack1Empty = true;
        for (char c : list.get(0).toCharArray()) {
            stk2.add(String.valueOf(c));
        }
        for (int i = 1; i < list.size(); i++) {
            for (char c : list.get(i).toCharArray()) {
                if (stack1Empty) {
                    for (String s1 : stk2) {
                        stk1.add(s1 + c);
                    }
                } else {
                    for (String s1 : stk1) {
                        stk2.add(s1 + c);
                    }
                }
            }
            if (stk1.size() > stk2.size()) {
                stack1Empty = false;
                stk2.clear();
            } else {
                stack1Empty = true;
                stk1.clear();
            }
        }
        return stk1.size() == 0 ? stk2 : stk1;

    }

    /**
     * 队列
     */
    public List<String> letterCombinations2(String digits){
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
        LinkedList<String> queue= new LinkedList<>();
        char[] chars = digits.toCharArray();
        for (char c : phoneMap.get(chars[0]).toCharArray()) {
            queue.offer(String.valueOf(c));
        }
        int queueSize = queue.size();
        for (int i = 1; i < chars.length; i++) {
            String s = phoneMap.get(chars[i]);
            while (queueSize!=0){
                String pop = queue.pop();
                queueSize--;
                for (char c : s.toCharArray()) {
                    queue.offer(pop + c);
                }
            }
            queueSize = queue.size();
        }
        return new ArrayList<>(queue);

    }


}
