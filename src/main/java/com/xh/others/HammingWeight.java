package com.xh.others;

import com.xh.common.ListNode;

import java.util.*;

/**
 * author  Xiao Hong
 * date  2021/3/22 19:29
 * description
 * https://leetcode-cn.com/problems/number-of-1-bits/submissions/
 */

public class HammingWeight {

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(3));
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s, c)));
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.computeIfAbsent("1", k -> "123" + k);
        objectObjectHashMap.computeIfAbsent("2", k -> null);
        System.out.println("objectObjectHashMap = " + objectObjectHashMap);

        String i = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String[] split = i.split("\n");
        System.out.println("split = " + Arrays.toString(split));

        System.out.println(maxRotateFunction2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println("projectionArea(new int[][]{\n                {1,0},{0,2}\n        }) = " + projectionArea(new int[][]{
                {1, 0}, {0, 2}
        }));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    //[3,2,1,0,1,0,0,1,2,2,1,0]
    //https://leetcode-cn.com/problems/shortest-distance-to-a-character/
    public static int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];
        boolean first = true;
        int lastIdx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                if (first) {
                    for (int j = 0; j < i; j++) {
                        res[j] = i - j;
                    }
                    first = false;
                } else {
                    for (int j = lastIdx; j < i; j++) {
                        res[j] = Math.min(j - lastIdx, i - j);
                    }
                }
                lastIdx = i;
            }
        }
        for (int j = lastIdx; j < chars.length; j++) {
            res[j] = j - lastIdx;
        }
        return res;
    }

    // "dir\n \tsubdir1\n \t\tfile1.ext\n \t\tsubsubdir1\n \tsubdir2\n \t\tsubsubdir2\n \t\t\tfile2.ext" 。'\n' 和 '\t' 分别是换行符和制表符。
    // https://leetcode-cn.com/problems/longest-absolute-file-path/
    public static int lengthLongestPath(String input) {


        return 0;

    }

    private static boolean isFile(String s) {
        return s.contains(".");
    }


    // https://leetcode-cn.com/problems/rotate-function/
    public static int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int val = 0;
            for (int j = 0; j < len; j++) {
                val += (nums[j] * ((i + j) % len));
            }
            res = Math.max(val, res);
        }
        return res;
    }


    // 1 2 3 4
    // 0 1 2 3
    // 1 2 3 0
    // 2 3 0 1
    // 3 0 1 2
    //
    public static int maxRotateFunction2(int[] nums) {
        int len = nums.length;
        int f0 = 0, arrSum = 0, res;
        for (int i = 0; i < len; i++) {
            arrSum += nums[i];
            f0 += (i * nums[i]);
        }
        res = f0;
        for (int i = 1; i < len; i++) {
            f0 += arrSum - len * nums[len - i];
            res = Math.max(res, f0);
        }
        return res;
    }

    //https://leetcode-cn.com/problems/binary-gap/submissions/
    public int binaryGap(int n) {
        int lastIdx = -1;
        int max = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                lastIdx = i;
            }
            max = lastIdx == -1 ? 0 : Math.max(i - lastIdx, max);
        }
        return max;
    }


    //https://leetcode-cn.com/problems/random-pick-index/
    class Solution {

        HashMap<Integer, List<Integer>> map = new HashMap();
        Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
                orDefault.add(i);
                map.put(nums[i], orDefault);
            }
        }

        public int pick(int target) {
            List<Integer> integers = map.get(target);
            return integers.get(random.nextInt(integers.size()));
        }
    }

    //https://leetcode-cn.com/problems/random-pick-index/  水塘抽样
    class Solution2 {

        int[] nums;

        Random random = new Random();

        public Solution2(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int ans = 0;
            for (int i = 0, ct = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    ct++;
                    if (random.nextInt(ct) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }


    //https://leetcode-cn.com/problems/linked-list-random-node/
    class Solution3 {

        ListNode hd;
        Random random = new Random();

        public Solution3(ListNode head) {
            this.hd = head;
        }

        public int getRandom() {
            int ct = 0, res = 0;
            ListNode node = hd;
            while (node != null) {
                ct++;
                if (random.nextInt(ct) == 0) {
                    res = node.val;
                }
                node = node.next;
            }
            return res;
        }
    }

    /**
     * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
     */
    public static int projectionArea(int[][] grid) {
        int xy = 0, xz = 0, yz = 0;
        for (int j = 0; j < grid.length; j++) {
            int cMaxXz = 0, maxYz = 0;
            for (int i = 0; i < grid[j].length; i++) {
                if (grid[j][i] != 0) {
                    xy++;
                }
                cMaxXz = Math.max(cMaxXz, grid[j][i]);
                maxYz = Math.max(maxYz, grid[i][j]);
            }
            xz += cMaxXz;
            yz += maxYz;
        }
        return xy + xz + yz;
    }
}
