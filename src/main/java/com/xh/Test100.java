package com.xh;

import com.xh.common.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class Test100 {

    //https://leetcode-cn.com/problems/majority-element/submissions/
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int count = 1, cur = nums[0];
        for (int num : nums) {
            if (cur == num) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cur = num;
                    count = 1;
                }
            }
        }
        return cur;
    }

    // 排序 中间数必定是大于一半的数
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // https://leetcode-cn.com/problems/majority-element-ii/
    public List<Integer> majorityElement3(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if (c1 != 0 && a == i) {
                c1++;
            } else if (c2 != 0 && b == i) {
                c2++;
            } else if (c1 == 0 && ++c1 >= 0) {
                a = i;
            } else if (c2 == 0 && ++c2 >= 0) {
                b = i;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (a == i) {
                c1++;
            } else if (b == i) {
                c2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (c1 > n / 3) {
            ans.add(a);
        }
        if (c2 > n / 3) {
            ans.add(b);
        }
        return ans;
    }


    //https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (nums[abs - 1] >= 0) {
                nums[abs - 1] = -nums[abs - 1];
            } else {
                res.add(abs);
            }
        }
        return res;
    }

    //https://leetcode.cn/problems/di-string-match/
    public int[] diStringMatch(String s) {
        int length = s.length();
        int[] res = new int[length + 1];
        int min = 0, max = length;
        for (int i = 0, idx = 0; i < length; i++) {
            if (s.charAt(i) == 'I') {
                res[idx++] = min++;
            } else {
                res[idx++] = max--;
            }
        }
        res[length] = min;
        return res;
    }

    public static void main(String[] args) {
        Test100 test100 = new Test100();
        System.out.println(Arrays.toString(test100.diStringMatch("IDID")));
    }


}
