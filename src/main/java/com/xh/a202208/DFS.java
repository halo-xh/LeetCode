package com.xh.a202208;

import com.xh.tree.Node;
import com.xh.tree.TreeNode;

import java.util.*;

/**
 * Created by Xiao Hong on 2022-08-15
 * </p>
 */
public class DFS {


    /**
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            node = pop.right;
        }
        TreeNode n = root;
        for (int i = 1; i < list.size(); i++) {
            n.left = null;
            n.right = list.get(i);
            n = n.right;
        }
    }

    // https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> linkedList = new LinkedList<>();
        linkedList.offer(root);
        int levelSize = 1;
        Node pre = root;
        while (!linkedList.isEmpty()) {
            Node node = linkedList.poll();
            levelSize--;
            if (levelSize > 0) {
                pre.next = node;
                pre = node;
            }
            if (node.left != null) {
                linkedList.offer(node.left);
            }
            if (node.right != null) {
                linkedList.offer(node.right);
            }
            if (levelSize == 0) {
                levelSize = linkedList.size();
                pre = linkedList.peek();
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

}
