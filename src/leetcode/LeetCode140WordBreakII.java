/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LeetCode140WordBreakII {

    /**
     * Solution 1
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {

        List<String> result = new ArrayList<>();
        if (null == s) {
            return result;
        }

        String curr = new String();
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = i; j <= s.length(); j++) {
                if (dp[j] && wordDict.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        wordBreakHelper(s, 0, curr, wordDict, result, dp);

        return result;
    }

    private void wordBreakHelper(String s, int index, String curr, Set<String> wordDict, List<String> result,
            boolean[] dp) {

        if (index == s.length()) {
            result.add(new String(curr.substring(1, curr.length())));
            return;
        }

        if (null == wordDict || wordDict.isEmpty() || !dp[index]) {
            return;
        }

        String[] wordArray = wordDict.toArray(new String[wordDict.size()]);
        for (int i = 0; i < wordArray.length; i++) {
            int len = wordArray[i].length();
            if (index + len <= s.length() && wordArray[i].equals(s.substring(index, index + len))) {
                String tmp = new String(curr);
                tmp = tmp + " " + wordArray[i];
                wordBreakHelper(s, index + len, tmp, wordDict, result, dp);
            }
        }
    }

    /**
     * Solution 2
     */

    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (null == s || s.isEmpty() || null == wordDict || wordDict.isEmpty()) {
            return result;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]) {
            return result;
        }

        wordBreakHelper2(s, wordDict, "", 0, dp, result);
        return result;
    }

    private void wordBreakHelper2(String s, List<String> wordDict, String curr, int index, boolean[] dp,
            List<String> result) {
        if (index == s.length()) {
            result.add(new String(curr.substring(1)));
            return;
        }

        if (!dp[index]) {
            return;
        }

        for (String word : wordDict) {
            if (index + word.length() <= s.length() && word.equals(s.substring(index, index + word.length()))) {
                String next = curr + " " + word;
                wordBreakHelper2(s, wordDict, next, index + word.length(), dp, result);
            }
        }
    }
}
