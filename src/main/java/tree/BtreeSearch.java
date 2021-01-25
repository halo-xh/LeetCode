package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BtreeSearch {

    // 前序遍历
    public void preOrderSearch(Node e) {
        System.out.println(e.element);
        preOrderSearch(e.left);
        preOrderSearch(e.right);
    }

    // zhong序遍历
    public void inOrderSearch(Node e) {
        preOrderSearch(e.left);
        System.out.println(e.element);
        preOrderSearch(e.right);
    }

    // hou序遍历
    public void postOrderSearch(Node e) {
        preOrderSearch(e.left);
        preOrderSearch(e.right);
        System.out.println(e.element);

    }

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
    public void calHeight(Node e) {
        if (e == null) {
            return;
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
    }

    // 利用 层序遍历 判断一棵树是否为完全二叉树
    public boolean isComplete(Node e) {
        if (e == null) {
            return false;
        }
        boolean isleaf = false; // 是叶子节点
        Queue queue = new LinkedList();
        queue.offer(e);
        while (!queue.isEmpty()) {
            Node ee = (Node) queue.poll();
            if (isleaf && (ee.right != null || ee.left != null)) {// 如果要求是叶子节点 但是却不是（左右节点有只=值
                return false;
            }
            if (ee.left != null && ee.right != null) {
                queue.offer(ee.left);
                queue.offer(ee.right);
            } else if (ee.left == null && ee.right != null) {
                return false;
            } else { // 接下来所有节点都必须是叶子节点
                isleaf = true;
                if (ee.left != null) {
                    queue.offer(ee.left);
                }
            }
        }
        return true;
    }

    // 利用 层序遍历 判断一棵树是否为完全二叉树
    public boolean isComplete2(Node e) {
        if (e == null) {
            return false;
        }
        boolean isleaf = false; // 是叶子节点
        Queue queue = new LinkedList();
        queue.offer(e);
        while (!queue.isEmpty()) {
            Node ee = (Node) queue.poll();
            if (isleaf && (ee.right != null || ee.left != null)) {// 如果要求是叶子节点 但是却不是（左右节点有只=值
                return false;
            }
            if (ee.left != null) {
                queue.offer(ee.left);
            } else {
                if (ee.right != null) return false;
            }
            if (ee.right != null) {
                queue.offer(ee.right);
            } else {
                isleaf = true;
            }
        }
        return true;
    }

    // 翻转二叉树 前序
    public Node revert1(Node e) {
        if (e == null) {
            return e;
        }
        Node tmp = e.left;
        e.left = e.right;
        e.right = tmp;
        preOrderSearch(e.left);
        preOrderSearch(e.right);
        return e;
    }

    // 翻转二叉树 hou序
    public Node revert3(Node e) {
        if (e == null) {
            return e;
        }
        preOrderSearch(e.left);
        preOrderSearch(e.right);
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
        preOrderSearch(e.left);
        Node tmp = e.left;
        e.left = e.right;
        e.right = tmp;
        preOrderSearch(e.left);
        return e;
    }

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
