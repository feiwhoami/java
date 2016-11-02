/**
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
package leetcode;

public class LeetCode151ReverseWordsinaString {

    public String reverseWords(String s) {

        if (null == s) {
            return null;
        }

        s = removeSpace(s);
        char[] c = s.toCharArray();

        reverse(c, 0, c.length - 1);

        int i = 0;
        int j = 0;

        while (j < c.length) {
            if (c[j] == ' ') {
                reverse(c, i, j - 1);
                j++;
                i = j;
            } else {
                j++;
            }
        }

        reverse(c, i, j - 1);

        return new String(c);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
    }

    private String removeSpace(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        while (j >= i && s.charAt(j) == ' ') {
            j--;
        }
        s = s.substring(i, j + 1);

        i = 0;
        j = 0;
        String result = new String();

        while (j < s.length()) {
            if (s.charAt(j) == ' ') {
                result = result + " ";
                result = result + s.substring(i, j);
                while (j < s.length() && s.charAt(j) == ' ') {
                    j++;
                }
                i = j;
            } else {
                j++;
            }
        }

        result = result + " ";
        result = result + s.substring(i, j);
        return result.substring(1, result.length());
    }
}
