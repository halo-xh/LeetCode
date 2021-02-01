package com.xh.jianzhioffer;

import com.xh.tree.TreeNode;

import java.util.*;

/**
 * author  Xiao Hong
 * date  2021/2/1 20:53
 * description
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */

public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * <p>
     *  
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *  
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        List<Integer> levelRes = new ArrayList<>();
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelSize--;
            levelRes.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                res.add(new ArrayList<>(levelRes));
                levelRes.clear();
            }
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * <p>
     *  
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        Deque<Integer> levelRes = new LinkedList<>(); // 用个双端队列
        int levelSize = 1;
        boolean reverse = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelSize--;
            if (reverse) {
                levelRes.addFirst(poll.val);
            } else {
                levelRes.addLast(poll.val);
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                res.add(new ArrayList<>(levelRes));
                levelRes.clear();
                reverse = !reverse;
            }
        }
        return res;
    }

}
