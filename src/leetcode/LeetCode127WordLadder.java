/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode127WordLadder {

    /**
     * Solution 1
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        if (null == beginWord || null == endWord || beginWord.length() == 0 || endWord.length() == 0 || null == wordList
                || wordList.size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();

        int currNum = 1;
        int nextNum = 0;
        int level = 1;

        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            currNum--;

            for (int i = 0; i < currWord.length(); i++) {
                char[] currArray = currWord.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    currArray[i] = c;
                    String nextWord = new String(currArray);

                    if (endWord.equals(nextWord)) {
                        return level + 1;
                    }

                    if (wordList.contains(nextWord)) {
                        queue.add(nextWord);
                        nextNum++;
                        wordList.remove(nextWord);
                    }
                }
            }

            if (currNum == 0) {
                level++;
                currNum = nextNum;
                nextNum = 0;
            }
        }

        return 0;
    }

    /**
     * Solution 2
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (null == beginWord || beginWord.isEmpty() || null == endWord || endWord.isEmpty() || null == wordList
                || wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }

        int level = 1;
        int currNum = 1;
        int nextNum = 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            currNum--;

            for (int i = 0; i < currWord.length(); i++) {
                char[] currArray = currWord.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    currArray[i] = c;
                    String nextWord = new String(currArray);

                    if (endWord.equals(nextWord)) {
                        return level + 1;
                    }

                    if (wordList.contains(nextWord)) {
                        queue.add(nextWord);
                        nextNum++;
                        wordList.remove(nextWord);
                    }
                }
            }

            if (currNum == 0) {
                level++;
                currNum = nextNum;
                nextNum = 0;
            }
        }
        return 0;
    }
}
