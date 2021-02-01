package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/2/1 21:39
 * description
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到<>叶节点</>所经过的节点形成一条路径。
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */

public class PathSum {

    /**
     * 递归
     * <p>
     * 求左子树 sum - root.val 或 sum - root.val
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {//todo. || sum<= root.val  sum可以为负数 = =
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSumm(root, sum, list, res);
        return res;
    }

    public void pathSumm(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        List<Integer> lres = new ArrayList<>(path);
//        // 找到值正好 todo.必须到叶子节点= =
//        if (sum == root.val) {
//            lres.add(root.val);
//            res.add(lres);
//            return;
//        }
        //  到底
        if (root.left == null && root.right == null) {
            // 找到值正好
            if (sum == root.val) {
                lres.add(root.val);
                res.add(lres);
                return;
            }
            return;
        }
        lres.add(root.val);
        pathSumm(root.left, sum - root.val, lres, res);
        pathSumm(root.right, sum - root.val, lres, res);
    }


}
