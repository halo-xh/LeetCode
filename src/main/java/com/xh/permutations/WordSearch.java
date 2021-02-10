package com.xh.permutations;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/6 15:53
 * https://leetcode-cn.com/problems/word-search/
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "SEE"));

    }

    boolean exist;

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        dfs(board, words, 0,0,0, used);
        return exist;
    }

    public void dfs(char[][] board, char[] arr, int n, int row, int col, boolean[][] used) {
        if (arr.length == n) {
            this.exist = true;
            return;
        }
        //==========
        System.out.println("->---");
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 <board[0].length; i1++) {
                if (beside(i, i1, row, col) && board[i][i1] == arr[n] && !used[i][i1]) {
                    used[i][i1] = true;
                    n++;
                    dfs(board, arr, n , i, i1, used);
                    used[i][i1] = false;
                    n=0;
                }
            }
        }
    }

    public boolean beside(int row, int col, int i, int j) {
        return Math.abs((row - i) + (col - j)) <= 1;
    }
}
