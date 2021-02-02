package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/2 17:39
 * @description https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 */
public class MaxDepth {

    /**
     * 层序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        int height = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelSize--;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 后序遍历
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

}
