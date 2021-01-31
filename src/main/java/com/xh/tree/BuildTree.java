package com.xh.tree;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 10:25
 * @description
 */
public class BuildTree {

    /**
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *       3
     *     /  \
     *    9   20
     *        / \
     *       15  7
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        // 前序遍历的第一个是root
        TreeNode treeNode = new TreeNode(preorder[0]);
        int i =0;

        return null;
    }
}
