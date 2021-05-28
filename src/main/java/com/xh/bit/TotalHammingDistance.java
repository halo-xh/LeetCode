package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/28 9:10
 * <p>
 * https://leetcode-cn.com/problems/total-hamming-distance/
 */
public class TotalHammingDistance {

    // OFT
    public int totalHammingDistance1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += hammingDistance(nums[i], nums[j]);
            }
        }
        return res;
    }

    // ref: https://leetcode-cn.com/problems/total-hamming-distance/solution/yi-ming-ju-chi-zong-he-by-leetcode-solut-t0ev/
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < 30; i++) {
            int count1 = 0;
            for (int num : nums) {
                count1 += (num >> i) & 1;
            }
            res += count1 * (length - count1);
        }
        return res;
    }

    public static int hammingDistance(int x, int y) {
        int a = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += 1 & (a >> i);
        }
        return res;
    }

}
