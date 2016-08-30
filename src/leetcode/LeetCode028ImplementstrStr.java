/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
package leetcode;

public class LeetCode028ImplementstrStr {

    public int strStr(String haystack, String needle) {

        if (null == needle || needle.isEmpty()) {
            return 0;
        }
        if (null == haystack || haystack.isEmpty()) {
            return -1;
        }

        int index = 0, i, j;

        while (index < haystack.length() - needle.length() + 1) {
            i = index;
            for (j = 0; j < needle.length(); i++, j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return index;
            }
            index++;
        }

        return -1;
    }
}
