package com.xh.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/5 14:27
 * @description https://leetcode-cn.com/problems/permutations/
 * <p>
 * 给定一个^没有重复^数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class ShuziQuanpai {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ls= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();
        dfs(nums,ls,res);
        return res;
    }

    /**
     * 简单法全部回溯
     */
    public void dfs(int[] nums, List<Integer> ans, List<List<Integer>> res) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int num : nums) {
            if (ans.contains(num)) {
                continue;
            }
            ans.add(num);
            dfs(nums, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

}
