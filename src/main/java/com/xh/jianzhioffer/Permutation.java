package com.xh.jianzhioffer;

import sun.dc.pr.PRError;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/5 11:18
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 *  
 */
public class Permutation {

    public static void main(String[] args) {
//        Permutation permutation = new Permutation();
//        System.out.println(Arrays.toString(permutation.permutation("dkjphedy")));

        char[] chars = "asdasds".toCharArray();
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
//        List<List<String>> res = new ArrayList<>();
//        List<String> ans = new ArrayList<>();
//        dfs(chars, ans, res);

//        List<String> res = new ArrayList<>();
        HashSet<String> res = new HashSet<>();
        boolean[] used = new boolean[chars.length];
        dfs2(chars, new StringBuilder(), res, used);
        return res.toArray(new String[0]);
    }

    public void dfs(char[] chars, List<String> ans, List<List<String>> res) {
        //if 满足结束条件:
        //result.add(路径)
        //return
        if (ans.size() == chars.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        //for 选择 in 选择列表:
        //做选择
        //backtrack(路径, 选择列表)
        //撤销选择
        for (int i = 0; i < chars.length; i++) {
            if (ans.contains(String.valueOf(chars[i]))) {
                continue;
            }
            ans.add(String.valueOf(chars[i]));
            dfs(chars, ans, res);
            ans.remove(ans.size() - 1);
        }
    }


    /**
     * 全列举  HashSet 去重
     * 38 ms	42.9 MB
     *
     * @param chars 选择区域
     * @param ans   阶段答案
     * @param res   最后总答案集
     * @param used  标记使用过的char
     */
    public void dfs2(char[] chars, StringBuilder ans, HashSet<String> res, boolean[] used) {
        if (ans.length() == chars.length) {
            // 字符串有重复
            res.add(ans.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            ans.append(chars[i]);
            used[i] = true;
            dfs2(chars, ans, res, used);
            ans.deleteCharAt(ans.length() - 1);
            used[i] = false;
        }
    }

    //==================================================
    public String[] permutation3(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> res = new ArrayList<>();
        boolean[] used = new boolean[chars.length];
        dfs3(chars, new StringBuilder(), res, used);
        return res.toArray(new String[0]);
    }

    /**
     * 排序优化
     * 12 ms	42.9 MB
     */
    public void dfs3(char[] chars, StringBuilder ans, ArrayList<String> res, boolean[] used) {
        if (ans.length() == chars.length) {
            res.add(ans.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || i > 0 && (chars[i] == chars[i - 1]) && used[i - 1]) {
                continue;
            }
            ans.append(chars[i]);
            used[i] = true;
            dfs3(chars, ans, res, used);
            ans.deleteCharAt(ans.length() - 1);
            used[i] = false;
        }
    }


}
