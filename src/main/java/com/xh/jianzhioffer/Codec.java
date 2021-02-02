package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;

import java.util.*;

/**
 * author  Xiao Hong
 * date  2021/2/1 22:52
 * description https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 树的层序遍历 空保存null。
 * 层序遍历结果还原成树
 */

public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder list = new StringBuilder();
        list.append("[");
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                list.append(poll.val).append(",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                list.append("null").append(",");
            }
        }
        list.replace(list.length() - 1, list.length(), "]");
        return list.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


    //
    // =====================================================
    //



    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder list = new StringBuilder();
        list.append("[");
        int levelSize = 1;
        int levem = 1;
        int n = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelSize--;
            if (poll != null) {
                list.append(poll.val).append(",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                list.append("null").append(",");
                queue.offer(null);
                queue.offer(null);
                n++;
                n++;
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                levem = queue.size();
                if (levem == n) {
                    break;
                } else {
                    n = 0;
                }
            }

        }
        list.replace(list.length() - 1, list.length(), "]");
        return list.toString();
    }


    // Decodes your encoded data to tree.
    //[1,2,3,null,null,4,5]
    public static TreeNode deserialize2(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        // 1 2 4 8
        if (split[0].equals("null")) {
            return null;
        }
        // int length = split.length;
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        // 等差数列求和 算出有多少层。 2^n - 1 > len ==> n =
//        int level = getLevel(length);
        root.left = new TreeNode(Integer.parseInt(split[0]));
        buildTree(split, root, 0);
        return root;
    }

    static void buildTree(String[] split, TreeNode node, int index) {
        if (node == null) {
            return;
        }
        if (2 * index + 1 >= split.length) {
            return;
        }
        node.left = split[2 * index + 1].equals("null") ? null : new TreeNode(Integer.parseInt(split[2 * index + 1]));
        buildTree(split, node.left, 2 * index + 1);
        if (2 * index + 2 >= split.length) {
            return;
        }
        node.right = split[2 * index + 2].equals("null") ? null : new TreeNode(Integer.parseInt(split[2 * index + 2]));
        buildTree(split, node.right, 2 * index + 2);
    }



    static int getLevel(int length) {
        int level = 1;
        while (Math.pow(2, level) <= length) {
            level++;
        }
        return level;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
