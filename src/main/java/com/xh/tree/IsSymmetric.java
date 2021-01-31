package com.xh.tree;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/29 13:04
 * @description https://leetcode-cn.com/problems/symmetric-com.xh.tree/
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricss(root.left, root.right);
    }

    private boolean isSymmetricss(TreeNode l, TreeNode r) {
        if (l != null && r != null) {
//            if (l.val != r.val){
//                return false;
//            }
            return l.val != r.val && isSymmetricss(l.left, r.right) && isSymmetricss(l.right, r.left);
        }
        return l == r;
    }


}
