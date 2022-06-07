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
public class FindMin2 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 0, 1};
        FindMin2 findMin = new FindMin2();
        System.out.println(findMin.findMin4(arr));
        System.out.println("5%$ = " + 5 % 4);
        ///[3,6,7,11], h = 8
        //[30,11,23,4,20], h = 5
        int i = findMin.minEatingSpeed(new int[]{30,11,23,4,20}, 5);
        System.out.println("i = " + i);
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
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     */
    public int findMin4(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > 0 && nums[right] == nums[0]) {
            right--;
        }
        if (left == right) {
            return nums[0];
        }
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] >= nums[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }


    /**
     * https://leetcode.cn/problems/koko-eating-bananas/
     */
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            int eat = eat(piles, mid);
            if (eat > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }

    private int eat(int[] piles, int mid) {
        int res = 0;
        for (int pile : piles) {
            int r = pile % mid;
            res += (r > 0 ? (pile / mid) + 1 : pile / mid);
        }
        return res;
    }

}
