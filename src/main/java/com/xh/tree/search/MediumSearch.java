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
 * @date 2021/1/26 12:57
 * @description 中序遍历
 */
public class MediumSearch {


    public void mdSearch(Node e) {
        if (e == null) {
            return;
        }
        mdSearch(e.left);
        System.out.println(e.element);
        mdSearch(e.right);
    }


    /**
     * 迭代
     */
    public List<Integer> ms(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            node = pop.right;
        }
        return res;
    }


}
