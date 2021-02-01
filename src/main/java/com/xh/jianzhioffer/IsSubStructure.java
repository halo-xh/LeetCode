package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;


/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/1 16:59
 * @description https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        return sameVal(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean sameVal(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return B == null;
        }
        return (A.val == B.val) && sameVal(A.right, B.right) && sameVal(A.left, B.left);
    }

}
