package com.xh.a2023919;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xiao Hong
 * @since 2023-09-19
 */
public class GoodLuck {


    //https://leetcode.cn/problems/hanota-lcci/
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }

    public static void move(List<Integer> A, List<Integer> B, List<Integer> C, int size) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(A, C, B, size - 1);
        C.add(A.remove(A.size() - 1));
        System.out.println("A.size() = " + A.size());
        move(B, A, C, size - 1);
    }


    //https://leetcode.cn/problems/different-ways-to-add-parentheses/
    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        return diffWaysToCompute1(0, chars.length, chars);
    }

    public static List<Integer> diffWaysToCompute1(int left, int right, char[] chars) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < right; i++) {
            if (chars[i] == '-' || chars[i] == '+' || chars[i] == '*') {
                List<Integer> r = diffWaysToCompute1(i + 1, right, chars);
                List<Integer> l = diffWaysToCompute1(left, i, chars);
                for (Integer integer : l) {
                    for (Integer integer1 : r) {
                        if (chars[i] == '-') {
                            res.add(integer - integer1);
                        } else if (chars[i] == '+') {
                            res.add(integer + integer1);
                        } else {
                            res.add(integer * integer1);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(new String(Arrays.copyOfRange(chars, left, right))));
        }
        return res;
    }

    //https://leetcode.cn/problems/longest-increasing-subsequence/description/
    public int lengthOfLIS(int[] nums) {
        int[] maxR = new int[nums.length];
        if (nums.length == 1) {
            return 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            maxR[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxR[i] = Math.max(maxR[i], maxR[j] + 1);
                }
            }
            res = Math.max(res, maxR[i]);
        }
        return res;
    }

    //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[i] - prices[j]);
            }
            res = Math.max(res, max);
        }
        return res;
    }

    //https://leetcode.cn/problems/longest-common-subsequence/description/
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] res = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    res[i + 1][j + 1] = res[i][j] + 1;
                } else {
                    res[i + 1][j + 1] = Math.max(res[i + 1][j], res[i][j + 1]);
                }
            }
        }
        return res[chars1.length][chars2.length];
    }

    //https://leetcode.cn/problems/longest-palindromic-subsequence/description/
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    //https://leetcode.cn/problems/TVdhkn/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> integers = new ArrayList<>(ans.get(j));
                integers.add(num);
                ans.add(integers);
            }
        }
        return ans;
    }

    public List<List<Integer>> subsetss(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfsSubsets(nums, 0, res, new LinkedList<Integer>());
        return res;
    }

    private void dfsSubsets(int[] nums, int i, ArrayList<List<Integer>> res, LinkedList<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; j++) {
            cur.addLast(nums[j]);
            dfsSubsets(nums, j + 1, res, cur);
            cur.removeLast();
        }
    }

    //https://leetcode.cn/problems/subsets-ii/description/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfsSubsets2(nums, 0, res, new LinkedList<Integer>());
        return res;
    }

    private void dfsSubsets2(int[] nums, int i, ArrayList<List<Integer>> res, LinkedList<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j - 1] == nums[j]) {
                continue;
            }
            cur.addLast(nums[j]);
            dfsSubsets2(nums, j + 1, res, cur);
            cur.removeLast();
        }
    }


    //https://leetcode.cn/problems/Ygoe9J/
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, 0, 0, target, res, new LinkedList<Integer>());
        return res;
    }

    private static void combinationSum(int[] nums, int i, int sum, int target, ArrayList<List<Integer>> res, LinkedList<Integer> cur) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (sum + nums[j] > target) {
                return;
            }
            sum += nums[j];
            cur.addLast(nums[j]);
            combinationSum(nums, j, sum, target, res, cur);
            sum -= nums[j];
            cur.removeLast();
        }
    }


    //https://leetcode.cn/problems/VvJkup/
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new LinkedList<>());
        return res;
    }


    public static void permute(int[] nums, ArrayList<List<Integer>> res, LinkedList<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int num : nums) {
            if (cur.contains(num)) {
                continue;
            }
            cur.addLast(num);
            permute(nums, res, cur);
            cur.removeLast();
        }
    }

    //https://leetcode.cn/problems/7p8L0Z/
    public static List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        permuteUnique(nums, res, new LinkedList<>(), used);
        return res;
    }

    public static void permuteUnique(int[] nums, ArrayList<List<Integer>> res, LinkedList<Integer> cur, int[] used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            cur.addLast(nums[i]);
            used[i] = 1;
            permuteUnique(nums, res, cur, used);
            cur.removeLast();
            used[i] = 0;
        }
    }


    //https://leetcode.cn/problems/M99OJA/
    public static String[][] partition(String s) {
        ArrayList<List<String>> res = new ArrayList<>();
        partition(s, 0, res, new LinkedList<>());
        List<String[]> collect = res.stream().map(a -> a.toArray(new String[0])).collect(Collectors.toList());
        return collect.toArray(new String[0][0]);
    }

    public static void partition(String s, int i, ArrayList<List<String>> res, LinkedList<String> cur) {
        if (i == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String substring = s.substring(i, j + 1);
            if (isHuiWen(substring)) {
                cur.addLast(substring);
                partition(s, j + 1, res, cur);
                cur.removeLast();
            }
        }
    }

    static HashMap<String, Boolean> map = new HashMap<>();

    private static boolean isHuiWen(String substring) {
        if (map.containsKey(substring)) {
            return map.get(substring);
        }
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - i - 1)) {
                map.put(substring, false);
                return false;
            }
        }
        map.put(substring, true);
        return true;
    }

    // https://leetcode.cn/problems/omKAoA/

    static int minCut = Integer.MAX_VALUE;

    public static int minCut(String s) {
        partition2(s, 0, new LinkedList<>());
        return minCut;
    }


    public static void partition2(String s, int i, LinkedList<String> cur) {
        if (cur.size() - 1 > minCut) {
            return;
        }
        if (i == s.length()) {
            minCut = Math.min(minCut, cur.size() - 1);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String substring = s.substring(i, j + 1);
            if (isHuiWen(substring)) {
                cur.addLast(substring);
                partition2(s, j + 1, cur);
                cur.removeLast();
            }
        }
    }


    //https://leetcode.cn/problems/ZL6zAn/description/
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                ans = Math.max(ans, maxAreaOfIslandDfs(ans, grid, j, i));
            }
        }
        return ans;
    }

    private int maxAreaOfIslandDfs(int ans, int[][] grid, int j, int i) {
        if (i < 0 || j < 0 || j == grid.length || i == grid[0].length || grid[j][i] == 0) {
            return 0;
        }
        grid[j][i] = 0;
        int ct = 1;
        ct += maxAreaOfIslandDfs(ct, grid, j - 1, i);
        ct += maxAreaOfIslandDfs(ct, grid, j + 1, i);
        ct += maxAreaOfIslandDfs(ct, grid, j, i - 1);
        ct += maxAreaOfIslandDfs(ct, grid, j, i + 1);
        return ct;
    }

    //https://leetcode.cn/problems/word-search/
    public boolean exist(char[][] board, String word) {
        return false;
    }

    public static int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        int i = numsDivide[0];
        for (int j : numsDivide) {
            i = gcd(i, j);
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            if (i % nums[k] == 0) {
                return k;
            }
        }
        return -1;
    }

    public static int countPoints(String rings) {
        int[] res = new int[100];
        int ans = 0;
        for (int i = 0; i < rings.length() - 1; i++) {
            char color = rings.charAt(i);
            int idx = rings.charAt(++i) - 48;
            if (color == 'R') {
                res[idx] |= 1;
            } else if (color == 'G') {
                res[idx] |= 2;
            } else if (color == 'B') {
                res[idx] |= 4;
            }
        }
        for (int re : res) {
            if (re == 7) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int i = minOperations(new int[0], new int[]{2, 6, 4});
        System.out.println("i = " + i);

        int b0R0G0R9R0B0G0 = countPoints("B0R0G0R9R0B0G0");
        System.out.println(b0R0G0R9R0B0G0);

        char a0 = '0';
        char a1 = '1';
        int i1 = a1 - 48;
        System.out.println("i1 = " + i1);

    }

}
