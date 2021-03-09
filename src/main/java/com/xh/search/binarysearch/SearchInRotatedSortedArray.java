package com.xh.search.binarysearch;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/6 15:29
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1};
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 2, arr.length)));
//        System.out.println(Arrays.toString(Arrays.copyOf(arr, 2)));

        System.out.println(search(arr, 1));
    }

    // O(log2n)
    // 通过判断数组的第一个值与目标值得大小关系用以确定是在左半段还是右半段。
    // 在左半段则将数组转化为 4，5,6 ，MAX,2,3
    // 在右半段 则转化为  4,5,MIN,1,2,3
    // 然后进行二分查找。
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return mid;
            }
            /**
             * 判断数组的第一个值与target 大小关系
             * 如果大于第一个值，说明在左半段
             */
            if (target >= nums[0]) {//= 注意等号
                // 已知在左半段，但是中间的值却小于第一个值，说明中间的这个值是右半段的，直接将其标识为MAX。
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                //  同理。 已知在右半段，但是中间的值却大于第一个值，说明中间的这个值是左半段的，直接将其标识为MIN。
                if (nums[mid] >= nums[0]) {//= 注意等号。 【3,1】的时候， num[mid] = 3, num[0] = 3. --> mid值左倾
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    // -----------------
    // O(n)..
    public static int search22(int[] nums, int target) {
        int split = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                split = i;
                break;
            }
        }
        if (nums[split] < target) {
            // 在后半段
            int back = search2(Arrays.copyOfRange(nums, split, nums.length), target);
            return back != -1 ? back + split : -1;
        } else {
            return search2(Arrays.copyOf(nums, split), target);
        }
    }

    private static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
