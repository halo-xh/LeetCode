package com.xh.window;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/7/19 17:06
 * <p>
 */
public class SlidWindow {

    /**
     * https://leetcode-cn.com/problems/permutation-in-string/
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>(s1.length());
        HashMap<Character, Integer> map = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (mapEquals(map1, map)) {
                return true;
            }
            map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            char charAt = s2.charAt(i + s1.length());
            map.put(charAt, map.getOrDefault(charAt, 0) + 1);
        }
        return mapEquals(map1, map);
    }

    private static boolean mapEquals(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        Set<Map.Entry<Character, Integer>> entries = map1.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (!map1.get(entry.getKey()).equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        short[] c1 = new short[26];
        short[] c2 = new short[26];
        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(c1, c2)) {
                return true;
            }
            c2[s2.charAt(i) - 'a']--;
            char charAt = s2.charAt(i + s1.length());
            c2[charAt - 'a']++;
        }
        return Arrays.equals(c1, c2);
    }

    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/palindrome-number/
     */
    public static boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        int length = value.length();
        for (int i = 0; i < length / 2; i++) {
            if (value.charAt(i) != value.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/longest-common-prefix/
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        String flag = null;
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
                flag = str;
            }
        }
        if (flag == null) {
            return res.toString();
        }
        for (int i = 0; i < flag.toCharArray().length; i++) {
            Character c = null;
            for (String str : strs) {
                c = str.charAt(i);
                if (c != flag.charAt(i)) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }

    /**
     * https://leetcode-cn.com/problems/search-insert-position/
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLen = 1, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    /**
     * https://leetcode-cn.com/problems/repeated-dna-sequences/
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return Collections.emptyList();
        }
        HashSet<String> res = new HashSet<>();
        HashSet<String> all = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String substring = s.substring(i - 10, i);
            if (all.contains(substring)) {
                res.add(substring);
            }
            all.add(substring);
        }
        return new ArrayList<>(res);
    }


    /**
     * https://leetcode-cn.com/problems/maximum-number-of-balloons/
     */
    public static int maxNumberOfBalloons(String text) {
        String b = "balloon";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (b.indexOf(text.charAt(i)) != -1) {
                map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
            }
        }
        return Math.min(Integer.MAX_VALUE, Math.min(Math.min(Math.min(Math.min(map.getOrDefault('b', 0), map.getOrDefault('a', 0)), map.getOrDefault('l', 0) / 2), map.getOrDefault('o', 0) / 2), map.getOrDefault('n', 0)));
    }

    public static int maxNumberOfBalloons2(String text) {
        char[] map = new char[5];
        for (int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            if (charAt == 'b') {
                map[0]++;
            } else if (charAt == 'a') {
                map[1]++;
            } else if (charAt == 'l') {
                map[2]++;
            } else if (charAt == 'o') {
                map[3]++;
            } else if (charAt == 'n') {
                map[4]++;
            }
        }
        map[2] /= 2;
        map[3] /= 2;
        int res = map[0];
        for (int i = 0; i < 5; i++) {
            res = Math.min(res, map[i]);
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/maximum-average-subarray-i/
     */
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = 0; i < nums.length - k; i++) {
            sum = sum - nums[i] + nums[i + k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }

    public static double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }

    /**
     * https://leetcode-cn.com/problems/sliding-window-median/
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            linkedList.addLast(nums[i]);
        }
        res[0] = getMid(linkedList);
        for (int i = k; i < nums.length; i++) {
            linkedList.pollFirst();
            linkedList.addLast(nums[i]);
            res[i - k + 1] = getMid(linkedList);
        }
        return res;
    }

    private static double getMid(List<Integer> nums) {
        ArrayList<Integer> integers = new ArrayList<>(nums);
        Collections.sort(integers);
        int t = nums.size() >> 1;
        if ((nums.size() & 1) == 1) {
            return integers.get(t);
        } else {
            return (Double.valueOf(integers.get(t)) + Double.valueOf(integers.get(t - 1))) / 2;
        }
    }

    public static double[] medianSlidingWindow2(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int[] copy = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(copy);
            int mid = k >> 1;
            if ((k & 1) == 1) {
                res[i] = copy[mid];
            } else {
                res[i] = ((double) copy[mid] + (double) copy[mid - 1]) / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int i = searchInsert(arr, 3);
        System.out.println("i = " + i);
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        System.out.println("abcabcbb = " + abcabcbb);
        List<String> aaaaacccccaaaaaccccccaaaaagggttt = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println("aaaaacccccaaaaaccccccaaaaagggttt = " + aaaaacccccaaaaaccccccaaaaagggttt);
        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion2(s1, s2));
        System.out.println(maxNumberOfBalloons2("leetcode"));
        int[] ar2 = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(findMaxAverage2(ar2, 1));
        System.out.println(Arrays.toString(medianSlidingWindow2(ar2, 3)));
        System.out.println("(1&3) = " + (1 & 3));
    }

}
