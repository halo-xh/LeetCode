package com.xh.tree.search;

import com.xh.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/26 12:52
 * @description 前序遍历
 */
public class FirstSearch {

    /**
     * 递归
     */
    public void ftSearch(TreeNode e) {
        if (e == null) {
            return;
        }
        System.out.println(e.val);
        ftSearch(e.left);
        ftSearch(e.right);
    }

    /**
     * 迭代
     */
    public List<Integer> fs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            node = pop.right;
        }
        return list;
    }

}
