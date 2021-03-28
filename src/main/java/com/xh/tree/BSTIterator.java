package com.xh.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
class BSTIterator {

    static Deque<Integer> deque = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        midSearch(root);
    }

    private static void midSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        midSearch(node.left);
        deque.addLast(node.val);
        midSearch(node.right);
    }

    public int next() {
        return deque.removeFirst();
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */