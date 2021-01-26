package tree;

import java.util.LinkedList;
import java.util.Queue;

public class RevertTree {

    // 翻转二叉树 前序
    public Node revert1(Node e) {
        if (e == null) {
            return e;
        }
        Node tmp = e.left;
        e.left = e.right;
        e.right = tmp;
        revert1(e.left);
        revert1(e.right);
        return e;
    }

    // 翻转二叉树 hou序
    public Node revert3(Node e) {
        if (e == null) {
            return e;
        }
        revert3(e.left);
        revert3(e.right);
        Node tmp = e.left;
        e.left = e.right;
        e.right = tmp;
        return e;
    }

    // 翻转二叉树 中序
    public Node revert2(Node e) {
        if (e == null) {
            return e;
        }
        revert2(e.left);
        Node tmp = e.left;
        e.left = e.right;
        e.right = tmp;
        revert2(e.left);
        return e;
    }

    // 层序
    public Node revert4(Node e) {
        if (e == null) {
            return e;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(e);
        while (!queue.isEmpty()) {
            Node ee = queue.poll();
            Node tmp = ee.left;
            ee.left = ee.right;
            ee.right = tmp;
            if (ee.left != null) {
                queue.offer(ee.left);
            }
            if (ee.right != null) {
                queue.offer(ee.right);
            }
        }
        return e;
    }

}
