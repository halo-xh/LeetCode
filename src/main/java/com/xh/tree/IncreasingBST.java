package com.xh.tree;

import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/25 12:23
 * <p>
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode start = new TreeNode(1);
        TreeNode right = new TreeNode();
        start.right = right;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            right.right = new TreeNode(pop.val);
            right = right.right;
            root = pop.right;
        }
        return start.right.right;
    }
}
