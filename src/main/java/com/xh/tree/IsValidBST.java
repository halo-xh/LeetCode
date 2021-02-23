package com.xh.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * author  Xiao Hong
 * date  2021/2/20 14:41
 * description
 */

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return fs(root);
    }

    // failed.
    public boolean fs(TreeNode node) {
        if (node.left != null) {
            if (node.left.val >= node.val) {
                return false;
            }
            fs(node.left);
        }
        if (node.right != null) {
            if (node.right.val <= node.val) {
                return false;
            }
            fs(node.right);
        }
        return true;
    }

    // 中序遍历 。 为升序
    long preVal = Integer.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValidBST2(root.left);

        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;

        isValidBST2(root.right);
        return preVal < root.val;
    }


    public boolean isValidBST3(TreeNode root) {
        int preVal = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            if (pop.val <= preVal) {
                return false;
            }
            preVal = pop.val;
            node = pop.right;
        }
        return true;
    }

}
