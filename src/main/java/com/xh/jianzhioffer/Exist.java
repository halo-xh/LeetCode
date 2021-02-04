package com.xh.jianzhioffer;

/**
 * author  Xiao Hong
 * date  2021/2/4 21:31
 * description https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 示例 1：
 * <p>
 * 输入：board =
 * [["A","B","C","E"]
 * ,["S","F","C","S"]
 * ,["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */

public class Exist {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 使用回溯法解题
                if (dfs(board, word.toCharArray(), i, j, 0)) return true;
            }

        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int w) {
        // 如果索引越界，或者值不匹配，返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[w]) {
            return false;
        }
        if (w == word.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '\0'; // 将当前元素标记为'\0'，即一个不可能出现在word里的元素，表明当前元素不可再参与比较
        if (dfs(board, word, i - 1, j, w + 1)
                || dfs(board, word, i + 1, j, w + 1)
                || dfs(board, word, i, j - 1, w + 1)
                || dfs(board, word, i, j + 1, w + 1)) {
            // 当前元素的上下左右，如果有匹配到的，返回true
            return true;
        }
        board[i][j] = temp; // 将当前元素恢复回其本身值
        return false;
    }
}
