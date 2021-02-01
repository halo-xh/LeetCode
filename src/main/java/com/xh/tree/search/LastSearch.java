package com.xh.tree.search;

import com.xh.tree.Node;
import com.xh.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/26 12:58
 * @description 后序遍历
 */
public class LastSearch {

    /**
     * 递归
     */
    public void ltOrderSearch(TreeNode e) {
        if (e == null) {
            return;
        }
        ltOrderSearch(e.left);
        ltOrderSearch(e.right);
        System.out.println(e.val);
    }

    /**
     * 迭代
     */
    public List<Integer> hs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode previous = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            if (pop.right == null || pop.right == previous) {// 叶子结点 或者 右节点已经出栈
               list.add(pop.val);
               previous  = pop; //记录前一个出栈节点
            }else {
                //右节点不为空 继续进栈
                stack.push(pop);
                node = pop.right;
            }
        }
        return list;

    }
}
