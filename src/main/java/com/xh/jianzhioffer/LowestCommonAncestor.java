package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/2 11:16
 * @description https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * <p>
 * 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {

    // 无脑转化为 两个数组求最后一个公共节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();
        TreeNode node = root;
        while (node.val != p.val) {
            plist.add(node);
            if (p.val > node.val && node.right != null) {
                node = node.right;
            }
            if (p.val < node.val && node.left != null) {
                node = node.left;
            }
            if (p.val == node.val) {
                break;
            }
        }
        while (node.val != q.val) {
            qlist.add(node);
            if (q.val > node.val && node.right != null) {
                node = node.right;
            }
            if (q.val < node.val && node.left != null) {
                node = node.left;
            }
            if (q.val == node.val) {
                break;
            }
        }
        for (int i = plist.size() - 1; i >= 0; i--) {
            TreeNode node1 = plist.get(i);
            for (int i2 = qlist.size() - 1; i2 >= 0; i2--) {
                if (qlist.get(i2).val == node1.val) {
                    return node1;
                }
            }
        }
        return null;
    }


    //递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        return root;
    }


    //    作者：jyd
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) { // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            } else if (root.val > p.val && root.val > q.val) { // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     * <p>
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        buildParentMap(root, map);
        List<TreeNode> plist = new ArrayList<>();
        TreeNode node = p;
        while (node != root) {
            plist.add(map.get(node));
            node = map.get(node);
        }
        node = q;
        while (node != root) {
            if (plist.contains(node)) {
                return node;
            }
            node = map.get(node);
        }
        return root;
    }

    void buildParentMap(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root.left == null) {
            return;
        }
        map.put(root.left, root);
        if (root.right == null) {
            return;
        }
        map.put(root.right, root);
        buildParentMap(root.left, map);
        buildParentMap(root.right, map);
    }


    //-=========================================================

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestorr(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    //=======================================
    // 递归
    public TreeNode lowestCommonAncestorrr(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || q == root || p == root) {
            return root;
        }
        //在左子树找p或q，假如p和q都在左子树，返回的那个值就是祖先
        TreeNode left = lowestCommonAncestorrr(root.left, p, q);
        //在右子树找p或者q，假如p和q都在右子树，返回的那个值就是祖先
        TreeNode right = lowestCommonAncestorrr(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // p和q一个在左子树一个在右子树
        return root;
    }


}
