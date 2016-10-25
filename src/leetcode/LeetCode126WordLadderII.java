/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LeetCode126WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        List<List<String>> result = new ArrayList<List<String>>();
        if (null == beginWord || null == endWord || null == wordList) {
            return result;
        }

        List<String> curr = new ArrayList<>();
        curr.add(beginWord);

        String[] wordArray = wordList.toArray(new String[wordList.size()]);

        findLaddersHelper(endWord, curr, wordArray, result);

        return result;
    }

    private void findLaddersHelper(String endWord, List<String> curr, String[] wordArray, List<List<String>> result) {

        if (null == curr || curr.isEmpty()) {
            return;
        }
        if (null != result && !result.isEmpty()) {
            if (result.get(0).size() <= curr.size()) {
                return;
            }
        }

        if (distance(curr.get(curr.size() - 1), endWord) == 1) {
            if (null != result && !result.isEmpty() && result.get(0).size() > curr.size() + 1) {
                result.clear();
            }
            curr.add(endWord);
            result.add(new ArrayList<String>(curr));
            curr.remove(curr.size() - 1);

            return;
        }

        String lastWord = curr.get(curr.size() - 1);
        for (int i = 0; i < wordArray.length; i++) {
            if (!curr.contains(wordArray[i]) && distance(lastWord, wordArray[i]) == 1) {
                curr.add(wordArray[i]);
                findLaddersHelper(endWord, curr, wordArray, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private int distance(String word1, String word2) {

        int result = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                result++;
            }
        }

        return result;
    }
}
