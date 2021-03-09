package com.xh.others.matrix;


/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * <p>
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 */
public class NumArray {

    int[] arr;


//    public NumArray(int[] nums) {
//        this.arr = nums;
//    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    //=============================
    private int[] arr2;

    public NumArray(int[] nums) {
        arr2 = new int[nums.length+1];
        arr2[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            arr2[i+1] = arr2[i] + nums[i];
        }
    }

    public int sumRange2(int i, int j) {
        return arr2[j+1] - arr2[i];
    }


}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
