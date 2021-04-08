package com.xh.search.binarysearch;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/6 17:38
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 */
public class FindMin {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1};
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin2(arr));
    }

    //O(n)
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    // O(log2n)
    public int findMin2(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];

    }


    /**
     * 2021-04-08
     */
    public int findMin3(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >>> 1;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
