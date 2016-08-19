/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 */
package leetcode;

public class LeetCode171ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        if (null == s) {
            return 0;
        }

        char[] c = s.toCharArray();
        int length = c.length;

        int result = 0;

        for (int i = 0; i < length; i++) {
            long digit = c[i] - '0' - 16;
            int pow = length - i - 1;
            result = (int) (result + digit * Math.pow(26, pow));
        }

        return result;
    }
}
