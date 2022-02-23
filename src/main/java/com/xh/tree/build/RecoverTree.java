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
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode node = root;
        while (!linkedList.isEmpty() || node != null) {
            while (node != null) {
                linkedList.push(node);
                node = node.left;
            }
            TreeNode pop = linkedList.pop();
            list.add(pop.val);
            node = pop.right;
        }
        // 查找影响递增的两个位置
        int i1 = -1, i2 = -1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                if (i1 == -1) {
                    i1 = i;
                } else {
                    i2 = i;
                }
            }
        }
        // 交换
        if (i2 == -1) {
            int t = list.get(i1);
            list.set(i1, list.get(i1 + 1));
            list.set(i1 + 1, t);
        }else {
            int t = list.get(i1);
            list.set(i1, list.get(i2));
            list.set(i2, t);
        }
        // 恢复树


    }


}
