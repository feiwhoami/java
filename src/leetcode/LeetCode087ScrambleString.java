/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
package leetcode;

import java.util.Arrays;

public class LeetCode087ScrambleString {

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }

        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);

        if (!new String(t1).equals(new String(t2))) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());

            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());

            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());

            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }

            if (isScramble(s11, s24) && isScramble(s12, s23)) {
                return true;
            }
        }

        return false;
    }

    public boolean isScramble2(String s1, String s2) {

        if (null == s1 || null == s2 || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        int len = s1.length();

        boolean[][][] result = new boolean[len][len][len + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                for (int j = 0; j < len - l + 1; j++) {
                    for (int k = 1; k < l; k++) {
                        boolean tmp1 = result[i][j][k] && result[i + k][j + k][l - k];
                        boolean tmp2 = result[i][j + l - k][k] && result[i + k][j][l - k];

                        result[i][j][l] = result[i][j][l] || tmp1 || tmp2;
                    }
                }
            }
        }

        return result[0][0][len];
    }
}
