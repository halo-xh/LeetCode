package com.xh.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/3/13 11:13
 * description
 * https://leetcode-cn.com/problems/design-hashset/
 */

public class HashImpl {

    List<Integer> myhash;

    /**
     * Initialize your data structure here.
     */
    public HashImpl() {
        myhash = new ArrayList<>();
    }

    public void add(int key) {
        if (myhash.contains(key)) {
            return;
        }
        myhash.add(key);
    }

    public void remove(int key) {
        if (!myhash.contains(key)) {
            return;
        }
        myhash.remove(new Integer(key));
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return myhash.contains(key);
    }

    private static class MyHash2 {
        int[] myhash;

        /**
         * Initialize your data structure here.
         */
        public MyHash2() {
            myhash = new int[1000000];
            Arrays.fill(myhash, -1);
        }

        public void add(int key) {
            myhash[key] = key;
        }

        public void remove(int key) {
            myhash[key] = -1;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return myhash[key] == key;
        }
    }

    /**
     * bitMap. 一个 int 32位。 每一位标记一个数的存在否。所以可以用 10^6/32 = 31250 个数表示
     */
    private static class MyHash3 {

        int[] myhash;

        /**
         * Initialize your data structure here.
         */
        public MyHash3() {
            myhash = new int[31250];
        }

        public void add(int key) {
            int bucket = key >>> 5;
            int index = key % 32;
            setVal(bucket, index, true);
        }

        public void remove(int key) {
            int bucket = key >>> 5;// 除32
            int index = key % 32;
            setVal(bucket, index, false);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int bucket = key >>> 5;
            int index = key % 32;
            return getVal(bucket, index);
        }

        void setVal(int bucket, int loc, boolean val) {
            if (val) {
                // 原值与 1 左移 index 位 再 位或运算（只要有个1就是1）
                int u = (myhash[bucket] | (1 << loc));
                myhash[bucket] = u;
            } else {
                // 原值与 1左移index位再取反 再做 位与运算（都是1才是1）
                int u = myhash[bucket] & ~(1 << loc);
                myhash[bucket] = u;
            }
        }

        boolean getVal(int bucket, int loc) {
            // 原值 右移index位 再 和1 做位与运算（都是1才是1,，是1 表示true）
            int u = (myhash[bucket] >> loc) & 1;
            return u == 1;
        }

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
