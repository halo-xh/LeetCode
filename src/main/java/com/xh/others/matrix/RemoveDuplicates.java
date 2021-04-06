package com.xh.others.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/6 9:26
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        RemoveDuplicates rm = new RemoveDuplicates();
        rm.removeDuplicates(a);
        System.out.println(Arrays.toString(a));

    }

    // 输入：nums = [0,0,1,1,1,1,2,3,3]
    //输出：7, nums = [0,0,1,1,2,3,3]
    public int removeDuplicates(int[] nums) {
        int dpcount = 0;
        int cur = nums[0];
        int count = 1;
        List<Integer> dpIndex = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                count++;
                if (count > 2) {
                    dpcount++;
                    dpIndex.add(i);
                }
            } else {
                cur = nums[i];
                count = 1;
            }
        }
        int mvd = 0;
        for (Integer index : dpIndex) {
            movefowd(nums, index - mvd);
            mvd++;
        }
        return nums.length - dpcount;
    }

    private void movefowd(int[] nums, int i) {
        for (int j = i; j < nums.length - 1; j++) {
            nums[j] = nums[j + 1];
        }
    }

    // 通法 数据有序，相同元素保留 k 位
    //------------------
    public  int removeDuplicates2(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) {
                nums[u++] = x;
            }
        }
        return u;
    }

}
