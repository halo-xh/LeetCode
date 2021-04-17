package com.xh.others;

import java.util.TreeSet;

/**
 * author  Xiao Hong
 * date  2021/4/17 11:31
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */

public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate duplicate = new ContainsNearbyAlmostDuplicate();
        System.out.println(duplicate.containsNearbyAlmostDuplicate2(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(duplicate.containsNearbyAlmostDuplicate2(new int[]{1, 2, 1, 1}, 1, 0));
        System.out.println(duplicate.containsNearbyAlmostDuplicate2(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(duplicate.containsNearbyAlmostDuplicate2(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(duplicate.containsNearbyAlmostDuplicate2(new int[]{-2147483648, 2147483647}, 1, 1));
    }

    // oot
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + (k - 1); j <= i + k && j < nums.length; j++) {
                long abs = Math.abs(Long.valueOf(nums[i]) - Long.valueOf(nums[j]));
                if (abs <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove((long) nums[i - k]);
        }
        return false;
    }

}
