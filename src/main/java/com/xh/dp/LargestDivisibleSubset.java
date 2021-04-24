package com.xh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/4/23 21:09
 * <p>
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 */

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{2, 4, 6, 9, 19, 81, 729}));

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(nums.length);
        ArrayList<Integer> first = new ArrayList<>(1);
        first.add(nums[0]);
        res.add(first);
        for (int i = 1; i < nums.length; i++) {
            ArrayList<Integer> current = new ArrayList<>();
            int maxsize = 1;
            current.add(nums[i]);
            res.add(current);
            for (int j = i - 1; j >= 0; j--) {
                boolean found = false;
                List<Integer> re = res.get(j);
                if (nums[i] % re.get(re.size() - 1) == 0) {
                    found = true;
                    if ((re.size() + 1) > maxsize) {
                        maxsize = re.size() + 1;
                        List<Integer> curres = new ArrayList<>(re);
                        curres.add(nums[i]);
                        res.set(i, curres);
                    }
                }
                if (!found) {
                    res.add(new ArrayList<>(nums[i]));
                }
            }
        }
        int maxIndex = 0;
        int maxsize = 1;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() > maxsize) {
                maxIndex = i;
                maxsize = res.get(i).size();
            }
        }
        return res.get(maxIndex);
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = prev;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }
        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }

}
