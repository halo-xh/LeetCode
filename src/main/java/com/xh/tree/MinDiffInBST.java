package com.xh.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/13 13:54
 * <p>
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinDiffInBST {


    public int minDiffInBST(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        TreeNode prev = null;
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if (prev != null) {
                ans = Math.min(ans, Math.abs(prev.val - root.val));
            }
            prev = root;
            root = root.right;
        }

        return ans;
    }


}
