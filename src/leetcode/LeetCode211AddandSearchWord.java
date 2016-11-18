/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
package leetcode;

import leetcode.util.TrieNode;

public class LeetCode211AddandSearchWord {

    private TrieNode root;

    public LeetCode211AddandSearchWord() {
        this.root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode curr) {

        if (index == word.length()) {
            return curr.isEnd;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    if (search(word, index + 1, curr.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else if (curr.children[c - 'a'] != null) {
            return search(word, index + 1, curr.children[c - 'a']);
        } else {
            return false;
        }
    }
}
