/**
 * Definition for a TrieNode.
 */
package leetcode.util;

public class TrieNode {

    // Initialize your data structure here.
    public boolean isEnd;

    public TrieNode[] children;

    public TrieNode() {
        this.isEnd = false;
        children = new TrieNode[26];
    }

    public void insert(String word, int index) {

        if (index == word.length()) {
            this.isEnd = true;
            return;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }

        children[pos].insert(word, index + 1);
    }

    public TrieNode find(String word, int index) {

        if (index == word.length()) {
            return this;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }

        return children[pos].find(word, index + 1);
    }
}
