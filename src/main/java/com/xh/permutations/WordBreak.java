package com.xh.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/17 22:23
 * @description https://leetcode-cn.com/problems/word-break/
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> list = Arrays.asList("aaaa", "aaa");
        System.out.println(wordBreak2(s, list));
    }

    /**
     * 执行结果：
     * 解答错误
     * 显示详情
     * 输入：
     * "aaaaaaa"
     * ["aaaa","aaa"]
     * 输出：
     * false
     * 预期结果：
     * true
     *
     * ???????????????????????
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size()==0){
            return false;
        }
        int p1 = 0, p2 = 0;
        while (p1 != s.length()) {
            if (p2 == s.length()+1) {
                p1++;
                p2 = p1;
            }
            String substring = s.substring(p1, p2);
            if (wordDict.contains(substring)) {
                p1 = p2;
                if (p2 == s.length()){
                    return true;
                }
            }
            p2++;
        }
        return false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        if (wordDict.size()==0){
            return false;
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true; // "" 为 true
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j);
                if (dp[i] && wordDict.contains(substring)){
                    dp[j] = true;
                    break;
                }
            }

        }
        return dp[s.length()-1];
    }
}
