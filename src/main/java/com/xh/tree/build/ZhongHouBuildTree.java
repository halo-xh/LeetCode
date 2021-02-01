package com.xh.tree.build;

import com.xh.tree.TreeNode;

import java.util.Collections;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/1 16:09
 * @description https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 *  3
 * /   \
 * 9     20
 *      /  \
 *   15   7
 * <p>
 * 3 9 20 15 7
 */
public class ZhongHouBuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0 || postorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inoderIndex = inorder.length -1;
        for (int postIndex = postorder.length - 2; postIndex >= 0; --postIndex) {
            TreeNode peek = stack.peek();
            int postVal = postorder[postIndex];
            if (peek.val != inorder[inoderIndex]){
                peek.right = new TreeNode(postVal);
                stack.push(peek.right);
            }else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inoderIndex]){
                    peek = stack.pop();
                    inoderIndex--;
                }
                peek.left = new TreeNode(postVal);
                stack.push(peek.left);
            }
        }
        return root;

    }
}
