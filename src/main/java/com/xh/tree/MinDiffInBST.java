package com.xh.tree;

import java.util.*;

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


    /**
     * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        int levelSize = 1;
        int max = Integer.MIN_VALUE;
        arrayDeque.addLast(root);
        while (!arrayDeque.isEmpty()) {
            TreeNode pop = arrayDeque.pop();
            max = Math.max(pop.val, max);
            levelSize--;
            if (pop.left != null) {
                arrayDeque.addLast(pop.left);
            }
            if (pop.right != null) {
                arrayDeque.addLast(pop.right);
            }
            if (levelSize == 0) {
                res.add(max);
                max = Integer.MIN_VALUE;
                levelSize = arrayDeque.size();
            }
        }
        return res;
    }

}
