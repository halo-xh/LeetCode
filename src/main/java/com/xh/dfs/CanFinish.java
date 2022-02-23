package com.xh.dfs;

import java.util.*;

/**
 * @author xiaohong
 * @date 2022/2/23 10:34
 **/
public class CanFinish {

    int[] visited;// 2 正在  1 完成  0  尚未
    boolean valid = true;
    List<List<Integer>> lists;

    /**
     * DFS
     * https://leetcode-cn.com/problems/course-schedule/
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        lists = new ArrayList<>(prerequisites.length);
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int i = prerequisite[1];
            lists.get(i).add(prerequisite[0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (valid && visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        //开始
        visited[i] = 2;
        List<Integer> integers = lists.get(i);
        for (Integer integer : integers) {
            if (visited[integer] == 0) {
                // 如果下个节点尚未遍历则继续遍历下个节点
                dfs(integer);
                if (!valid) {
                    return;
                }

            } else if (visited[integer] == 2) {
                // 如果下个节点正在遍历表示成环
                valid = false;
                return;
            } else if (visited[integer] == 1) {
                // 如果下个节点已经遍历则继续
            }
        }
        //结束
        visited[i] = 1;
    }


    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] inDegree;

    /**
     * BFS
     * https://leetcode-cn.com/problems/course-schedule/
     */
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int i1 = prerequisite[0];
            inDegree[i1]++;
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(i1);
            map.put(prerequisite[1],list);
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                stack.push(i);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            count++;
            List<Integer> integers = map.get(pop);
            if (integers != null) {
                for (Integer integer : integers) {
                    inDegree[integer]--;
                    if (inDegree[integer] == 0) {
                        stack.push(integer);
                    }
                }
            }
        }
        return count == numCourses;
    }

}
