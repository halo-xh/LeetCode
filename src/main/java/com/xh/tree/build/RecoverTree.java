package com.xh.tree.build;

import com.xh.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaohong
 * @date 2022/2/23 17:54
 * <p>
 * https://leetcode-cn.com/problems/recover-binary-search-tree/submissions/
 **/
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        // 中序遍历恢复树
        List<TreeNode> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode node = root;
        while (!linkedList.isEmpty() || node != null) {
            while (node != null) {
                linkedList.push(node);
                node = node.left;
            }
            TreeNode pop = linkedList.pop();
            list.add(pop);
            node = pop.right;
        }
        // 查找影响递增的两个位置 恢复树
        int n1 = -1;
        for (int i = 1; i < list.size(); i++) {
            TreeNode treeNode = list.get(i - 1);
            if (list.get(i).val < treeNode.val) {
                if (n1 == -1) {
                    n1 = i - 1;
                } else {
                    int v = treeNode.val;
                    list.get(i - 1).val = list.get(n1).val;
                    list.get(n1).val = v;
                }
            }
        }
    }

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree2(TreeNode root) {

        in_order(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void in_order(TreeNode root) {
        if (root == null) return;
        in_order(root.left);
        if (firstNode == null && preNode.val > root.val) firstNode = preNode;
        if (firstNode != null && preNode.val > root.val) secondNode = root;
        preNode = root;
        in_order(root.right);
    }


}
