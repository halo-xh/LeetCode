package com.xh.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author  Xiao Hong
 * date  2021/2/20 15:20
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 */

public class MinDepth {


    // 层序遍历
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelSize--;
            // 如果为叶子节点 直接返回深度
            if (poll.left == null && poll.right == null) {
                return level;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                level++;
            }
        }
        return level;
    }

}
