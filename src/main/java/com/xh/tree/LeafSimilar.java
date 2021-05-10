package com.xh.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Semaphore;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/10 9:06
 * <p>
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class LeafSimilar {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafVals1 = getLeafVals(root1);
        List<Integer> leafVals2 = getLeafVals(root2);
        if (leafVals1.size() != leafVals2.size()) {
            return false;
        }
        for (int i = 0; i < leafVals1.size(); i++) {
            if (!leafVals1.get(i).equals(leafVals2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getLeafVals(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> vals = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.left == null && pop.right == null) {
                vals.add(pop.val);
            }
            root = pop.right;
        }
        return vals;
    }

    // --------------------------------------


    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);

    private volatile int val1 = -1;
    private volatile boolean finished1 = false;
    private volatile boolean finished2 = false;
    private volatile boolean same = true;


    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        while (!(finished1 || finished2)) {
            new Thread(() -> getLeafVals2(root1)).start();
            new Thread(() -> getLeafVals2(root2)).start();
        }
        return same && finished1 && finished2;
    }


    private void getLeafVals2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        try {
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode pop = stack.pop();
                if (pop.left == null && pop.right == null) {
                    semaphore1.acquire();
                    val1 = pop.val;
                    semaphore2.release();
                }
                root = pop.right;
            }
            finished1 = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getLeafVals3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        try {
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode pop = stack.pop();
                if (pop.left == null && pop.right == null) {
                    semaphore2.acquire();
                    int val2 = pop.val;
                    if (val1 != val2) {
                        same = false;
                        finished2 = true;
                    }
                    semaphore1.release();
                }
                root = pop.right;
            }
            finished2 = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
