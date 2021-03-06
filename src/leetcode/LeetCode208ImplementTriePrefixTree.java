/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
package leetcode;

import leetcode.util.TrieNode;

public class LeetCode208ImplementTriePrefixTree {

    private TrieNode root;

    public LeetCode208ImplementTriePrefixTree() {
        this.root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        if (null != node && node.isEnd) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        if (null != node) {
            return true;
        } else {
            return false;
        }

    }
}
