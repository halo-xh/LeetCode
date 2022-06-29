package com.xh.sort;

import java.util.*;

/**
 * 快速排序
 * author  Xiao Hong
 * date  2020/8/17 23:57
 * description
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] aa = {4, 2, 1, 2, 2, 3, 3};
        //concatArray();
        System.out.println(Arrays.toString(quickSort(aa)));
        System.out.println(Arrays.toString(qs(aa, 0, aa.length - 1)));
        System.out.println("sortArrayByParity(aa) = " + Arrays.toString(sortArrayByParity(aa)));
    }

    /**
     * 原始版本 。 D&C  分而治之。 一边小于，一边大于。 递归。
     *
     * @param arr Array
     * @return sorted Array
     */
    private static int[] quickSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int flag = arr[0];
        int[] greater = Arrays.stream(Arrays.copyOfRange(arr, 1, arr.length)).filter(x -> x > arr[0]).toArray();
        int[] less = Arrays.stream(Arrays.copyOfRange(arr, 1, arr.length)).filter(x -> x <= arr[0]).toArray();
        return Arrays.stream(new int[][]{quickSort(less), new int[]{flag}, quickSort(greater)}).flatMapToInt(Arrays::stream).toArray();
    }

    /**
     * 优化 空间占用。 从右向左遍历， 交换基准值与小于基准值的值。 从左向右遍历，交换大于基准值的值
     * <p>
     * 快速排序只是使用数组原本的空间进行排序，所以所占用的空间应该是常量级的，但是由于每次划分之后是递归调用，所以递归调用在运行的过程中会消耗一定的空间，
     * 在一般情况下的空间复杂度为 O(logn)，在最差的情况下，若每次只完成了一个元素，那么空间复杂度为 O(n)。所以我们一般认为快速排序的空间复杂度为 O(logn)。
     */
    private static int[] quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int key = arr[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && arr[j] >= key) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                }
                System.out.println(Arrays.toString(arr));
                while (i < j && arr[i] <= key) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
                System.out.println(Arrays.toString(arr));
            }
            arr[i] = key;
            quickSort(arr, begin, i - 1);
            quickSort(arr, i + 1, end);
        }
        return arr;
    }

    /**
     *
     */
    private static int[] qs(int[] arr, int left, int right) {
        if (left < right) {
            int flag = arr[right], smidx = left - 1;
            int temp;
            for (int i = left; i < right; i++) {
                if (arr[i] <= flag) {
                    smidx++;
                    temp = arr[i];
                    arr[i] = arr[smidx];
                    arr[smidx] = temp;
                }
            }
            temp = arr[right];
            arr[right] = arr[smidx + 1];
            arr[smidx + 1] = temp;
            qs(arr, left, smidx);
            qs(arr, smidx + 2, right);
        }
        return arr;
    }

    /**
     * Stream 合并数组
     */
    private static void concatArray() {
        int[] aa = {4, 2, 1, 2, 3};
        int[] aa1 = {44, 2, 1, 2, 3};
        int[] aa2 = {4444, 2, 1, 2, 3};
        int[] ints = Arrays.stream(new int[][]{aa, aa1, aa2}).flatMapToInt(Arrays::stream).toArray();
        System.out.println(Arrays.toString(ints));
    }

    public int sumOfUnique(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                sum += entry.getKey();
            }
        }
        return sum;
    }


    /**
     * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
     */
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int[] ints = qs(nums, 0, nums.length - 1);
        int min = ints[k - 1] - ints[0];
        for (int i = k; i < ints.length; i++) {
            min = Math.min(ints[i] - ints[i - k + 1], min);
        }
        return min;
    }


    /**
     * 求交集
     * https://leetcode-cn.com/problems/intersection-of-multiple-arrays/
     */
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int[] num : nums) {
            for (int j : num) {
                Integer orDefault = map.getOrDefault(j, 0);
                map.put(j, ++orDefault);
                if (orDefault == nums.length) {
                    res.add(j);
                }
            }
        }
        Collections.sort(res);
        return res;
    }


    /**
     *
     */
    public int countLatticePoints(int[][] circles) {
        Set<List<Integer>> res = new HashSet<>();
        for (int[] circle : circles) {
            int r = circle[2];
            int x = circle[0];
            int y = circle[1];
            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    if (((x - i) * (x - i) + (y - j) * (y - j)) <= r * r) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return res.size();
    }


    public static int[] sortArrayByParity(int[] nums) {
        int m = 0, n = 0;
        while (m < nums.length && n < nums.length) {
            if ((nums[m] & 1) == 0 && m > n) {
                int temp = nums[m];
                nums[m] = nums[n];
                nums[n] = temp;
            }
            if ((nums[n] & 1) == 0) {
                n++;
            }
            m++;
        }
        return nums;
    }

    //https://leetcode.cn/problems/wiggle-sort-ii/
    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }
        int j = 5000;
        //插空放 较大元素
        for (int i = 1; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
        //插空放 较小元素
        for (int i = 0; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
    }

}
