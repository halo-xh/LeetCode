package com.xh.a202208;

import com.xh.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = null;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (node != null) {
                node.right = pop;
                node.left = null;
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            node = pop;
        }
    }

    // ref: https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
    //https://leetcode.cn/problems/number-of-islands/
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfsIsland(i, j, grid);
                }
            }
        }
        return res;
    }

    private void dfsIsland(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfsIsland(x + 1, y, grid);
            dfsIsland(x - 1, y, grid);
            dfsIsland(x, y + 1, grid);
            dfsIsland(x, y - 1, grid);
        }
    }

    //https://leetcode.cn/problems/max-area-of-island/
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int r = dfsAreaIsland(i, j, grid);
                    res = Math.max(r, res);
                }
            }
        }
        return res;
    }

    private int dfsAreaIsland(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            return 1 + dfsAreaIsland(x - 1, y, grid)
                    + dfsAreaIsland(x + 1, y, grid)
                    + dfsAreaIsland(x, y - 1, grid)
                    + dfsAreaIsland(x, y + 1, grid);
        }
        return 0;
    }

    // https://leetcode.cn/problems/island-perimeter/
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = dfsPerimeterIsland(i, j, grid);
                }
            }
        }
        return res;
    }

    private int dfsPerimeterIsland(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 1;
        }
        if (grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            return dfsPerimeterIsland(x - 1, y, grid)
                    + dfsPerimeterIsland(x + 1, y, grid)
                    + dfsPerimeterIsland(x, y - 1, grid)
                    + dfsPerimeterIsland(x, y + 1, grid);
        }
        return 0;
    }

    //https://leetcode.cn/problems/making-a-large-island/submissions/
    public int largestIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        HashMap<Integer, Integer> area = new HashMap<>();
        int idx = 2;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int r = dfsLargestIsland(i, j, grid, idx);
                    res = Math.max(res, r);
                    area.put(idx++, r);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, combineArea(i, j, grid, area) + 1);
                }
            }
        }
        return res;
    }

    private int combineArea(int i, int j, int[][] grid, HashMap<Integer, Integer> area) {
        HashSet<Integer> idxSet = new HashSet<>();
        if (i - 1 >= 0) {
            idxSet.add(grid[i - 1][j]);
        }
        if (j - 1 >= 0) {
            idxSet.add(grid[i][j - 1]);
        }
        if (i + 1 < grid.length) {
            idxSet.add(grid[i + 1][j]);
        }
        if (j + 1 < grid[0].length) {
            idxSet.add(grid[i][j + 1]);
        }
        int r = 0;
        for (Integer integer : idxSet) {
            r += area.getOrDefault(integer, 0);
        }
        return r;
    }

    private int dfsLargestIsland(int x, int y, int[][] grid, int idx) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        if (grid[x][y] == 1) {
            grid[x][y] = idx;
            return 1 + dfsLargestIsland(x - 1, y, grid, idx)
                    + dfsLargestIsland(x + 1, y, grid, idx)
                    + dfsLargestIsland(x, y - 1, grid, idx)
                    + dfsLargestIsland(x, y + 1, grid, idx);
        }
        return 0;
    }

    //https://leetcode.cn/problems/clone-graph/
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> cloned = new HashMap();
        return cloneNode(node, cloned);
    }

    private Node cloneNode(Node node, HashMap<Node, Node> cloned) {
        if (node == null) {
            return null;
        }
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }
        Node cn = new Node(node.val, new ArrayList<>());
        cloned.put(node, cn);
        if (node.neighbors != null) {
            for (Node neighbor : node.neighbors) {
                cn.neighbors.add(cloneNode(neighbor, cloned));
            }
        }
        return cn;
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
    public Node1 connect(Node1 root) {
        if (root == null) {
            return null;
        }
        Queue<Node1> linkedList = new LinkedList<>();
        linkedList.offer(root);
        int levelSize = 1;
        Node1 pre = root;
        while (!linkedList.isEmpty()) {
            Node1 node = linkedList.poll();
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

    public Node1 connect2(Node1 root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node1> queue = new LinkedList<Node1>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node1 node = queue.poll();

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

    static class Node1 {
        public int val;
        public Node1 left;
        public Node1 right;
        public Node1 next;

        public Node1() {
        }

        public Node1(int _val) {
            val = _val;
        }

        public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    // https://leetcode.cn/problems/successor-lcci/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!linkedList.isEmpty() || node != null) {
            while (node != null) {
                linkedList.push(node);
                node = node.left;
            }
            TreeNode pop = linkedList.pop();
            if (pre == p) {
                return pop;
            }
            pre = pop;
            node = pop.right;
        }
        return null;
    }


    // https://leetcode.cn/problems/surrounded-regions/
    public void solve(char[][] board) {
        LinkedList<List<int[]>> toChange = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] == 'O') {
                    ArrayList<int[]> rs = new ArrayList<>();
                    boolean solve = dfsSolve(i, k, board, rs);
                    if (solve) {
                        toChange.addLast(rs);
                    } else {
                        for (int[] ints : rs) {
                            board[ints[0]][ints[1]] = 'O';
                        }
                    }
                }
            }
        }
        for (List<int[]> ints : toChange) {
            for (int[] anInt : ints) {
                board[anInt[0]][anInt[1]] = 'X';
            }
        }
    }

    private boolean dfsSolve(int x, int y, char[][] grid, List<int[]> toChange) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] == 'O') {
            toChange.add(new int[]{x, y});
            grid[x][y] = 'A';
            return dfsSolve(x + 1, y, grid, toChange) &&
                    dfsSolve(x - 1, y, grid, toChange) &&
                    dfsSolve(x, y + 1, grid, toChange) &&
                    dfsSolve(x, y - 1, grid, toChange);
        }
        return true;
    }


    //  https://leetcode.cn/problems/course-schedule-ii/
    // 拓扑排序 BFS、ref:https://leetcode.cn/problems/course-schedule-ii/solution/java-jian-dan-hao-li-jie-de-tuo-bu-pai-xu-by-kelly/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 统计入度
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        // 将可以直接学习即入度为0的加入队列
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                linkedList.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int ct = 0;
        while (!linkedList.isEmpty()) {
            // 将队列中的值取出
            Integer poll = linkedList.poll();
            res[ct++] = poll;
            // 将依赖该值的课程的入度减1
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == poll) {
                    // 减到0就入队
                    if (--inDegree[prerequisite[0]] == 0) {
                        linkedList.offer(prerequisite[0]);
                    }
                }
            }
        }
        // 如果全部入队 即有结果
        if (ct == numCourses) {
            return res;
        }
        return new int[0];
    }

    //https://leetcode.cn/problems/paths-with-sum-lcci/
    int ct = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }


        return ct;
    }

    public void pathSum2(TreeNode root, int sum) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode node = root;
        int s = 0;
        while (!linkedList.isEmpty() || node != null && s <= sum) {
            while (node != null && s <= sum) {
                linkedList.push(node);
                s += node.val;
                if (s == sum) {
                    ct++;
                }
                node = node.left;
            }
            TreeNode pop = linkedList.pop();
            s -= pop.val;
            if (s == sum) {
                ct++;
            }
            node = pop.right;
        }
    }


}
