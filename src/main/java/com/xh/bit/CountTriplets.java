package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/18 9:19
 * <p>
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/submissions/
 */
public class CountTriplets {

    public int countTriplets(int[] arr) {
        // 前缀异或数组
        int[] preORX = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            preORX[i + 1] = preORX[i] ^ arr[i];
        }
        int res = 0;
        // 寻找前缀抑或数组中相同的两项
        for (int i = 0; i < preORX.length; i++) {
            for (int j = i + 2; j < preORX.length; j++) {
                if (preORX[i] == preORX[j]) {
                    res += j - i - 1;
                }
            }
        }
        return res;

    }

    public int countTriplets2(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int ans = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                ans ^= arr[k];
                if (ans == 0) {
                    count += k - i;
                }
            }
        }
        return count;
    }
}
