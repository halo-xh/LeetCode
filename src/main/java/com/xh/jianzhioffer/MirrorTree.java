package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;

import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/1 18:04
 * @description
 */
public class MirrorTree {


    /**
     * 递归
     */
    public TreeNode mirrorTree(TreeNode root) {
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//        return root;

        if (root == null) {
            return null;
        }
        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    /**
     * 循环
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            TreeNode tmp = pop.left;
            pop.left = pop.right;
            pop.right = tmp;
        }
        return root;
    }

}
