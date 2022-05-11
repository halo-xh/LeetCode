package com.xh.tree.build;

import com.xh.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> mid = new ArrayList<>();
        levelSearch(root, mid);
        return String.join(",", mid);
    }

    private void levelSearch(TreeNode root, List<String> vals) {
        if (root == null){
            vals.add("#");
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        vals.add(String.valueOf(root.val));
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.left != null){
                deque.offer(poll.left);
                vals.add(String.valueOf(poll.left.val));
            }else {
                vals.add("#");
            }
            if (poll.right != null){
                deque.offer(poll.right);
                vals.add(String.valueOf(poll.right.val));
            }else {
                vals.add("#");
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split.length == 0 || "#".equals(split[0])) {
            return null;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        deque.offer(root);
        int i = 0;
        while (!deque.isEmpty() && i != split.length - 1) {
            TreeNode poll = deque.poll();
            i++;
            if (i < split.length && !"#".equals(split[i])) {
                poll.left = new TreeNode(Integer.parseInt(split[i]));
                deque.offer(poll.left);
            }
            i++;
            if (i < split.length && !"#".equals(split[i])) {
                poll.right = new TreeNode(Integer.parseInt(split[i]));
                deque.offer(poll.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
    }
}
