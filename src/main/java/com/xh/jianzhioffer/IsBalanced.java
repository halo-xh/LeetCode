package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/2 9:49
 * @description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 */
public class IsBalanced {


    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return balanced(root.left,root.right);
    }

    public boolean balanced(TreeNode left, TreeNode right) {
        int lh = getDepth(left);
        int rh = getDepth(right);
        return lh > rh ? lh - rh < 2 : rh - lh < 2;
    }

    public int rootHeight(TreeNode root) {
        if (root == null) {
            return 0;
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

    //获取以node为根的子树深度
    public int getDepth(TreeNode node) {
        if(node == null){
            return 0;
        }
        int l = getDepth(node.left) + 1;
        int r = getDepth(node.right) + 1;
        return Math.max(r, l);
    }


    public boolean isBalanced2(TreeNode root) {
        return (recur(root) != -1);
    }

    public int recur(TreeNode root)
    {
        if(root == null) {
            return 0;
        }
        int left = recur(root.left);
        if(left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if(right == -1) {
            return -1;
        }
        if(Math.abs(left-right) < 2) {
            return Math.max(left,right)+1;
        } else {
            return -1; //超过平衡值了
        }

    }
}
