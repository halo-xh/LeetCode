package tree.search;

import tree.GenerateTrees;
import tree.Node;
import tree.TreeNode;

import javax.print.DocFlavor;
import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/26 12:51
 * @description
 */
public class LevelSearch {

    // 层序遍历 用队列
    public void layerOrderSearch(Node e) {
        if (e == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(e);
        while (!queue.isEmpty()) {
            Node ee = queue.poll();
            System.out.println(ee.element);
            if (ee.left != null) {
                queue.offer(ee.left);
            }
            if (ee.right != null) {
                queue.offer(ee.right);
            }
        }
    }


    // 利用 层序遍历 计算树的高度
    public int calHeight(Node e) {
        if (e == null) {
            return 0;
        }
        int height = 0;
        int levelSize = 1;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(e);
        while (!queue.isEmpty()) {
            Node ee = queue.poll();
            System.out.println(ee.element);
            levelSize--;
            if (ee.left != null) {
                queue.offer(ee.left);
            }
            if (ee.right != null) {
                queue.offer(ee.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }


    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 中序遍历 数组打印
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode ee = queue.poll();
            levelSize--;
            levelList.add(ee.val);
            if (ee.left != null) {
                queue.offer(ee.left);
            }
            if (ee.right != null) {
                queue.offer(ee.right);
            }
            if (levelSize == 0){
                res.add(new ArrayList<>(levelList));
                levelList.clear();
                levelSize = queue.size();
            }
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * 104. 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        int levelSize = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode ee = queue.poll();
            System.out.println(ee.val);
            levelSize--;
            if (ee.left != null) {
                queue.offer(ee.left);
            }
            if (ee.right != null) {
                queue.offer(ee.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 107. 二叉树的层序遍历 II
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int levelSize = 1;
        queue.offer(root);
        List<Integer> levelVal = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            levelVal.add(poll.val);
            levelSize--;
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
            if (levelSize==0){
                res.push(new ArrayList<>(levelVal));
                levelVal.clear();
                levelSize =  queue.size();
            }
        }
        return res;
    }

    /**
     * 103. 二叉树的锯齿形层序遍历
     * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
     *
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root ==null){
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        linkedList.offer(root);
        int levelSize = 1;
        boolean order  =true;
        while (!linkedList.isEmpty()){
            TreeNode node = linkedList.poll();
            levelSize--;
            if (order){
                queue.addLast(node.val);
            }else {
                queue.addFirst(node.val);
            }
            if (node.left!=null){
                linkedList.offer(node.left);
            }
            if (node.right!=null){
                linkedList.offer(node.right);
            }
            if (levelSize == 0){
                levelSize = linkedList.size();
                res.add(new ArrayList<>(queue));
                queue.clear();
                order = !order;
            }
        }
        return res;
    }

}
