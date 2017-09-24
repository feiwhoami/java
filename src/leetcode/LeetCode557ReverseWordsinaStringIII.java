/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *  Example 1:
 *  Input: "Let's take LeetCode contest"
 *  Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
package leetcode;

public class LeetCode557ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        while (start < c.length) {
            int end = start;
            while (end < c.length && c[end] != ' ') {
                end++;
            }
            reverseWordsHelper(c, start, end - 1);
            start = end + 1;
        }

        return new String(c);
    }

    private void reverseWordsHelper(char[] c, int start, int end) {
        while (start <= end) {
            char tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start++;
            end--;
        }
        return;
    }
}
