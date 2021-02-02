package com.xh.jianzhioffer;

import com.xh.tree.Node;
import com.xh.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/2 17:12
 * @description https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * <p>
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 二叉搜索树的第k大节点
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 */
public class KthLargest {

    /**
     * 中序遍历
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
//        mdSearch(root,list); 递归
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) {
                node = pop.right;
            }
        }
        return list.get(list.size() - k);
    }

    /**
     * 中序遍历  优化 提前结束
     */
    public int kthLargest2(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right; // 倒着
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            node = pop.left;  // 倒着 所以list成为递减
            // 提前结束
            if (list.size()==k){
                return list.get(k-1);
            }
        }
        return list.get(k-1);
    }

    public void mdSearch(TreeNode e, List<Integer> list) {
        if (e == null) {
            return;
        }
        mdSearch(e.left, list);
//        System.out.println(e.val);
        list.add(e.val);
        mdSearch(e.right, list);
    }


}
