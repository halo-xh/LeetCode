package tree;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/29 9:11
 * https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p!=null && q!=null){
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return p == q;
    }

}
