package com.xh.bfs;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/6/28 10:58
 * @description
 */
public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int site : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[site] = 1;
            que.offer(site);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int site : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[site] != -1) {
                ret = Math.min(ret, dis[site]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }


    /**
     * https://leetcode-cn.com/problems/minimum-genetic-mutation/
     * 题目要求将一个基因序列 A 变化至另一个基因序列 B，需要满足一下条件：
     * <p>
     * 1。 序列 A 与 序列 B 之间只有一个字符不同；
     * 2。 变化字符只能从 {`A', `C', `G', `T'} 中进行选择；
     * 3。 变换后的序列 B 一定要在字符串数组 bank 中。
     */
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(bank));
        if (!hashSet.contains(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        char[] keys = new char[]{'A', 'C', 'G', 'T'};
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast(start);
        int res = 1;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            //开始处理这一层。 这一层的结果都是上一次变化的结果
            for (int k = 0; k < size; k++) {
                String pop = linkedList.pop();
                for (int i = 0; i < pop.length(); i++) {
                    for (char key : keys) {
                        if (pop.charAt(i) != key) {
                            StringBuilder stringBuffer = new StringBuilder(pop);
                            stringBuffer.setCharAt(i, key);
                            String s = stringBuffer.toString();
                            if (hashSet.contains(s)) {
                                if (s.equals(end)) {
                                    return res;
                                }
                                linkedList.offer(s);
                            }
                        }
                    }
                }
            }
            // 每次队列里剩余的都是一次改变的结果。 所以处理完所有元素再加一
            res++;
        }
        return -1;
    }

}
