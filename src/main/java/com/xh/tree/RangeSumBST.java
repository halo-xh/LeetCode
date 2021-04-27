package com.xh.tree;

import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/27 18:53
 * <p>
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.val > high) {
                return sum;
            }
            if (pop.val >= low) {
                sum += pop.val;
            }
            root = pop.right;
        }
        return sum;
    }

}
