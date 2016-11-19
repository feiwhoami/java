/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.util.TrieNode;

public class LeetCode212WordSearchII {

    private Set<String> set = new HashSet<>();
    private TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        for (int i = 0; i < words.length; i++) {
            root.insert(words[i], 0);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWordsHelper(board, visited, i, j, "", root);
            }
        }

        return new ArrayList<String>(set);
    }

    public void findWordsHelper(char[][] board, boolean[][] visited, int i, int j, String curr, TrieNode root) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        curr = curr + board[i][j];
        if (root.find(curr, 0) == null) {
            return;
        }

        if (root.find(curr, 0).isEnd) {
            set.add(curr);
        }

        visited[i][j] = true;
        findWordsHelper(board, visited, i - 1, j, curr, root);
        findWordsHelper(board, visited, i + 1, j, curr, root);
        findWordsHelper(board, visited, i, j - 1, curr, root);
        findWordsHelper(board, visited, i, j + 1, curr, root);
        visited[i][j] = false;
    }
}
