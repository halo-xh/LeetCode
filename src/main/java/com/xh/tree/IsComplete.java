package com.xh.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author  Xiao Hong
 * date  2021/1/31 20:28
 * description
 * 判断是 完全二叉树 度为 0 1 2
 * <p>
 * 1. 如果树不为空，开始层序遍历二叉树
 * 2. treeNode.left !=null && treeNode.right !=null 左右节点都不为空 将左右节点入队
 * 3. treeNode.left == null && treeNode.right !=null 返回false
 * 4. treeNode.left !=null && treeNode.right == null 或者treeNode.left == null && treeNode.right ==null 后面的节点都需是叶子节点。
 */

public class IsComplete {

    public boolean isCplt(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        boolean mustBeLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (mustBeLeaf && !isLeaf(node)) {
                return false;
            }
            if (node.left != null && node.right != null) {
                //左右节点都不为空 将左右节点入队
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (node.left == null && node.right != null) {
                return false;
            }
            if (node.left == null) {//&& node.right == null
                mustBeLeaf = true;
            }
            if (node.left != null && node.right == null) {
                mustBeLeaf = true;
                queue.offer(node.left);
            }

        }
        return true;
    }

    /**
     * 判断是叶子节点
     */
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // 利用 层序遍历 判断一棵树是否为完全二叉树
    public boolean isComplete(Node e) {
        if (e == null) {
            return false;
        }
        boolean isleaf = false; // 是叶子节点
        Queue queue = new LinkedList();
        queue.offer(e);
        while (!queue.isEmpty()) {
            Node ee = (Node) queue.poll();
            if (isleaf && (ee.right != null || ee.left != null)) {// 如果要求是叶子节点 但是却不是（左右节点有值
                return false;
            }
            if (ee.left != null && ee.right != null) {
                queue.offer(ee.left);
                queue.offer(ee.right);
            } else if (ee.left == null && ee.right != null) {
                return false;
            } else { // 接下来所有节点都必须是叶子节点
                isleaf = true;
                if (ee.left != null) {
                    queue.offer(ee.left);
                }
            }
        }
        return true;
    }

    // 利用 层序遍历 判断一棵树是否为完全二叉树
    public boolean isComplete2(TreeNode e) {
        if (e == null) {
            return false;
        }
        boolean isleaf = false; // 是叶子节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(e);
        while (!queue.isEmpty()) {
            TreeNode ee = queue.poll();
            if (isleaf && (ee.right != null || ee.left != null)) {// 如果要求是叶子节点 但是却不是（左右节点有只=值
                return false;
            }
            if (ee.left != null) {
                queue.offer(ee.left);
            } else {
                if (ee.right != null) {
                    return false;
                }
            }
            if (ee.right != null) {
                queue.offer(ee.right);
            } else {
                isleaf = true;
            }
        }
        return true;
    }


}
