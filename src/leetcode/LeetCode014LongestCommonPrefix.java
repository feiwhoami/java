/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
package leetcode;

public class LeetCode014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String result = "";

        if (0 == strs.length) {
            return result;
        }

        for (int index = 0; index < strs[0].length(); index++) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    return result;
                }

                if (strs[i].charAt(index) != strs[0].charAt(index)) {
                    return result;
                }
            }
            result = result + strs[0].charAt(index);

        }

        return result;
    }
}
