package com.xh.jianzhioffer;

import com.xh.tree.Node;
import com.xh.tree.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 10:25
 * @description
 */
public class BuildTree {

    /**
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 前序遍历 preorder = [3,9,20,5,10,15,7]
     * 中序遍历 inorder = [5,9,10,3,15,20,7]
     * 3
     * /   \
     * 9    20
     * / \    / \
     * 5  10  15  7
     */

    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
    int[] preorder;//保留的先序遍历，方便递归时依据索引查看先序遍历的值

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //三个索引分别为
        //当前根的的索引
        //递归树的左边界，即数组左边界
        //递归树的右边界，即数组右边界
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;// 相等的话就是自己
        }
        TreeNode root = new TreeNode(preorder[pre_root]);//获取root节点
        int idx = map.get(preorder[pre_root]);//获取在中序遍历中根节点所在索引，以方便获取左子树的数量
        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来的中序in_left
        //递归右子树的右边界为中序中的根节点索引-1
        root.left = recur(pre_root + 1, in_left, idx - 1);
        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        //递归右子树的左边界为中序中当前根节点+1
        //递归右子树的右边界为中序中原来右子树的边界
        root.right = recur(pre_root + (idx - in_left) + 1, idx + 1, in_right);
        return root;

    }


    /**
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 前序遍历 preorder = [3,9,20,5,10,15,7]
     * 中序遍历 inorder = [5,9,10,3,15,20,7]
     *       3
     *    /    \
     *   9     20
     *  / \   /  \
     * 5  10  15  7
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 前序遍历 preorder = [3,9,20,5,10,15,7]
     * 中序遍历 inorder = [5,9,10,3,15,20,7]
     *       3
     *    /    \
     *   9     20
     *  / \   /  \
     * 5  10  15  7
     *
     * 初始时令中序遍历的指针指向第一个元素，遍历前序遍历的数组，
     * 如果前序遍历的元素不等于中序遍历的指针指向的元素，则前序遍历的元素为上一个节点的左子节点。
     * 如果前序遍历的元素等于中序遍历的指针指向的元素，则正向遍历中序遍历的元素同时反向遍历前序遍历的元素，
     * 找到最后一次相等的元素，将前序遍历的下一个节点作为最后一次相等的元素的右子节点。
     * 其中，反向遍历前序遍历的元素可通过栈的弹出元素实现。
     *
     */

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex = 0;
        // 遍历 前序数组
        for (int preorderIndex = 1; preorderIndex< preorder.length ; preorderIndex++) {
            // 前序值
            int preVal = preorder[preorderIndex];
            TreeNode node = stack.peek();
            // 如果前序遍历的值不等于 中序的值， 则遍历到的值都是上一个节点的左节点值
            if (node.val != inorder[inorderIndex]){ // todo. node.val != inorder[inorderIndex] 而不是 preVal， 可以把最后相等的哪一个也放到left
                node.left =  new TreeNode(preVal);
                stack.push(node.left);
            }else { //如果相同，则表示遍历到最左。
                // 开始 ”正向遍历中序遍历的元素同时反向遍历前序遍历的元素，“
                while (!stack.isEmpty() && stack.peek().val==inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                // 找到最后一次相等的元素，将前序遍历的下一个节点作为最后一次相等的元素的右子节点。
                node.right  = new TreeNode(preVal);
                stack.push(node.right);
            }


        }
        return root;
    }

}
