/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * Output: 5
 */
package leetcode;

public class LeetCode434NumberofSegmentsinaString {

    public int countSegments(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        char[] c = s.toCharArray();

        int result = 0;
        int i = 0;

        while (i < c.length && c[i] == ' ') {
            i++;
        }

        if (i == c.length) {
            return 0;
        }

        boolean prevSpace = false;
        while (i < c.length) {
            if (c[i] != ' ') {
                prevSpace = false;
                i++;
            } else {
                if (!prevSpace) {
                    result++;
                }
                if (i == c.length - 1) {
                    result--;
                }
                prevSpace = true;
                i++;
            }
        }

        return result + 1;
    }

    public int countSegments2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                result++;
            }
        }
        return result;
    }
}
