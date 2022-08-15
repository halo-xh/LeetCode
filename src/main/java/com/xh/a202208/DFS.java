package com.xh.a202208;

import com.xh.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Xiao Hong on 2022-08-15
 * </p>
 */
public class DFS {


    /**
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            node = pop.right;
        }
        TreeNode n = root;
        for (int i = 1; i < list.size(); i++) {
            n.left = null;
            n.right = list.get(i);
            n = n.right;
        }
    }

}
